package com.kodlamaio.bootcampProject.business.concretes.blacklists;

import com.kodlamaio.bootcampProject.business.abstracts.applications.ApplicationService;
import com.kodlamaio.bootcampProject.business.abstracts.blacklists.BlacklistService;
import com.kodlamaio.bootcampProject.business.abstracts.users.ApplicantService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.blacklists.AddBlacklistRequest;
import com.kodlamaio.bootcampProject.business.requests.blacklists.UpdateBlacklistRequest;
import com.kodlamaio.bootcampProject.business.requests.bootcamps.UpdateBootcampRequest;
import com.kodlamaio.bootcampProject.business.responses.blacklists.AddBlacklistResponse;
import com.kodlamaio.bootcampProject.business.responses.blacklists.GetAllBlacklistResponse;
import com.kodlamaio.bootcampProject.business.responses.blacklists.GetBlacklistResponse;
import com.kodlamaio.bootcampProject.business.responses.blacklists.UpdateBlacklistResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.blacklists.BlacklistRepository;
import com.kodlamaio.bootcampProject.entities.blacklists.Blacklist;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlacklistManager implements BlacklistService {
    BlacklistRepository blacklistRepository;

    ApplicantService applicantService;
    ApplicationService applicationService;

    ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllBlacklistResponse>> getAll() {
        List<Blacklist> blacklists=blacklistRepository.findAll();
        List<GetAllBlacklistResponse> responses=blacklists.stream()
                .map(blacklist -> modelMapperService.forResponse().map(blacklist,GetAllBlacklistResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(responses);
    }

    @Override
    public DataResult<GetBlacklistResponse> getById(int id) {
        Blacklist blacklist=blacklistRepository.findById(id).get();
        GetBlacklistResponse response=modelMapperService.forResponse().map(blacklist,GetBlacklistResponse.class);
        return new SuccessDataResult<>(response);
    }

    @Override
    public DataResult<AddBlacklistResponse> add(AddBlacklistRequest request) {
        checkIfApplicantInBlacklist(request.getApplicantId());
        Blacklist blacklist = modelMapperService.forRequest().map(request, Blacklist.class);
        blacklist.setId(0);
        blacklistRepository.save(blacklist);
        Result result = applicationService.findApplicationAndDeleteFromApplicationByApplicantId(request.getApplicantId());
        AddBlacklistResponse data = modelMapperService.forResponse().map(blacklist, AddBlacklistResponse.class);

        StringBuilder message=new StringBuilder().append(Messages.BlacklistCreated).append(result.getMessage());

        return new SuccessDataResult<>(data, message.toString());

    }

    @Override
    public DataResult<UpdateBlacklistResponse> update(UpdateBlacklistRequest request) {
        Blacklist blacklist = modelMapperService.forRequest().map(request, Blacklist.class);
        blacklist.setId(blacklist.getId());
        blacklistRepository.save(blacklist);
        UpdateBlacklistResponse data = modelMapperService.forResponse().map(blacklist, UpdateBlacklistResponse.class);

        return new SuccessDataResult<>(data, Messages.BlacklistUpdated);

    }

    @Override
    public Result delete(int id) {
        checkIfBlacklistExistById(id);
        blacklistRepository.deleteById(id);

        return new SuccessResult(Messages.BlacklistDeleted);

    }

    @Override
    public void checkIfApplicantInBlacklist(int applicantId) {
        if (blacklistRepository.existsBlacklistByApplicantId(applicantId)) {
            throw new BusinessException(Messages.ApplicantInBlacklist);
        }

    }
    private void checkIfBlacklistExistById(int id) {
        if (!blacklistRepository.existsById(id)) {
            throw new BusinessException(Messages.BlacklistNotExist);
        }
    }
}
