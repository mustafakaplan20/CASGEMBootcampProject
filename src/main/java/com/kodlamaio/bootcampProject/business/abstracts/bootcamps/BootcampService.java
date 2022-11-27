package com.kodlamaio.bootcampProject.business.abstracts.bootcamps;

import com.kodlamaio.bootcampProject.business.requests.bootcamps.AddBootcampRequest;
import com.kodlamaio.bootcampProject.business.requests.bootcamps.UpdateBootcampRequest;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.AddBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.GetAllBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.GetBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.UpdateBootcampResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import java.util.List;

public interface BootcampService {
    DataResult<AddBootcampResponse> add(AddBootcampRequest addBootcampRequest);
    DataResult<UpdateBootcampResponse> update (UpdateBootcampRequest updateBootcampRequest);
    Result delete (int id);
    DataResult<List<GetAllBootcampResponse>> getAll();
    DataResult<GetBootcampResponse> getById(int id);

}
