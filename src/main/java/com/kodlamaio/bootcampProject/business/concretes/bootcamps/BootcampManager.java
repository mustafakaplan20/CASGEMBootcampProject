package com.kodlamaio.bootcampProject.business.concretes.bootcamps;

import com.kodlamaio.bootcampProject.business.abstracts.bootcamps.BootcampService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.bootcamps.AddBootcampRequest;
import com.kodlamaio.bootcampProject.business.requests.bootcamps.UpdateBootcampRequest;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.AddBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.GetAllBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.GetBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.UpdateBootcampResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.bootcamps.BootcampRepository;
import com.kodlamaio.bootcampProject.entities.bootcamps.Bootcamp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {
    BootcampRepository bootcampRepository;

    ModelMapperService modelMapperService;

    @Override
    public DataResult<AddBootcampResponse> add(AddBootcampRequest addBootcampRequest) {
        checkBootcampDateIntervalForAdd(addBootcampRequest);
        Bootcamp bootcamp = this.modelMapperService.forRequest().map(addBootcampRequest, Bootcamp.class);
        bootcampRepository.save(bootcamp);
        AddBootcampResponse addBootcampResponse = this.modelMapperService.forResponse().map(bootcamp, AddBootcampResponse.class);
        return new SuccessDataResult<AddBootcampResponse>(addBootcampResponse, Messages.BootcampCreated);
    }

    @Override
    public DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest) {
        checkBootcampDateIntervalForUpdate(updateBootcampRequest);
        Bootcamp bootcamp = this.modelMapperService.forRequest().map(updateBootcampRequest, Bootcamp.class);
        bootcampRepository.save(bootcamp);
        UpdateBootcampResponse updateBootcampResponse = this.modelMapperService.forResponse().map(bootcamp, UpdateBootcampResponse.class);
        return new SuccessDataResult<UpdateBootcampResponse>(updateBootcampResponse,Messages.BootcampUpdated);
    }

    @Override
    public Result delete(int id) {
        this.bootcampRepository.deleteById(id);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<GetAllBootcampResponse>> getAll() {
        List<Bootcamp> bootcamps=bootcampRepository.findAll();

        List<GetAllBootcampResponse> getAllBootcampResponses = bootcamps.stream()
                    .map(bootcamp-> this.modelMapperService.forResponse().map(bootcamp, GetAllBootcampResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllBootcampResponse>>(getAllBootcampResponses);
    }

    @Override
    public DataResult<GetBootcampResponse> getById(int id) {
        Bootcamp bootcamp=bootcampRepository.findById(id).get();
        GetBootcampResponse response=modelMapperService.forResponse().map(bootcamp,GetBootcampResponse.class);
        return new SuccessDataResult<>(response);
    }

    private void checkBootcampDateIntervalForAdd(AddBootcampRequest request){
        if(request.getEndDate().isBefore(request.getStartDate())||request.getEndDate().equals(request.getStartDate()))
            throw new BusinessException("Please Check Your Date Interval!");
    }
    private void checkBootcampDateIntervalForUpdate(UpdateBootcampRequest request){
        if(request.getEndDate().isBefore(request.getStartDate())||request.getEndDate().equals(request.getStartDate()))
            throw new BusinessException("Please Check Your Date Interval!");
    }

}
