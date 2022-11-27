package com.kodlamaio.bootcampProject.business.abstracts.applications;

import com.kodlamaio.bootcampProject.business.requests.applications.AddApplicationRequest;
import com.kodlamaio.bootcampProject.business.requests.applications.UpdateApplicationRequest;
import com.kodlamaio.bootcampProject.business.responses.applications.AddApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.applications.GetAllApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.applications.GetApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.applications.UpdateApplicationResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import java.util.List;

public interface ApplicationService {
    DataResult<List<GetAllApplicationResponse>> getAll();
    DataResult<GetApplicationResponse> getById(int id);
    DataResult<AddApplicationResponse> add(AddApplicationRequest request);
    DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest request);
    Result delete(int id);
    Result findApplicationAndDeleteFromApplicationByApplicantId(int id);
}
