package com.kodlamaio.bootcampProject.business.concretes.applications;

import com.kodlamaio.bootcampProject.business.abstracts.applications.ApplicationService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.applications.AddApplicationRequest;
import com.kodlamaio.bootcampProject.business.requests.applications.UpdateApplicationRequest;
import com.kodlamaio.bootcampProject.business.responses.applications.AddApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.applications.GetAllApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.applications.GetApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.applications.UpdateApplicationResponse;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.applications.ApplicationRepository;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.users.ApplicantRepository;
import com.kodlamaio.bootcampProject.entities.applications.Application;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {
    ApplicationRepository applicationRepository;
    ApplicantRepository applicantRepository;

    ModelMapperService modelMapperService;

    @Override
    public DataResult<AddApplicationResponse> add(AddApplicationRequest addApplicationRequest) {
        Application application = this.modelMapperService.forRequest().map(addApplicationRequest, Application.class);
        //checkIfApplicantExistsByNationalId(applicant.getNationalId());
        applicationRepository.save(application);
        AddApplicationResponse addApplicationResponse = this.modelMapperService.forResponse().map(application, AddApplicationResponse.class);
        return new SuccessDataResult<AddApplicationResponse>(addApplicationResponse, Messages.ApplicationCreated);
    }


    @Override
    public DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateApplicationRequest) {
        Application application = this.modelMapperService.forRequest().map(updateApplicationRequest, Application.class);
        //checkIfApplicantExistsById(applicant.getId());
        applicationRepository.save(application);
        UpdateApplicationResponse updateApplicationResponse = this.modelMapperService.forResponse().map(application, UpdateApplicationResponse.class);
        return new SuccessDataResult<UpdateApplicationResponse>(updateApplicationResponse,Messages.ApplicationUpdated);
    }

    @Override
    public Result delete(int id) {
        this.applicationRepository.deleteById(id);
        return new SuccessResult();
    }

    @Override
    public Result findApplicationAndDeleteFromApplicationByApplicantId(int applicantId) {
        Application application = applicationRepository.findApplicationByApplicantId(applicantId);
        if (application.getApplicant()!=null) {
            applicationRepository.deleteById(application.getId());

            return new SuccessResult(Messages.ApplicationDeleted);
        }

        return new SuccessResult(Messages.ApplicantNotExistsInApplication);

    }

    @Override
    public DataResult<List<GetAllApplicationResponse>> getAll() {
        List<Application> applications = applicationRepository.findAll();
        List<GetAllApplicationResponse> getAllApplicationResponses = applications.stream()
                .map(application-> this.modelMapperService.forResponse().map(application, GetAllApplicationResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllApplicationResponse>>(getAllApplicationResponses);
    }

    @Override
    public DataResult<GetApplicationResponse> getById(int id) {
        Application application = this.applicationRepository.findById(id).get();
        GetApplicationResponse response = this.modelMapperService.forResponse().map(application, GetApplicationResponse.class);
        return new SuccessDataResult<GetApplicationResponse>(response);
    }
}
