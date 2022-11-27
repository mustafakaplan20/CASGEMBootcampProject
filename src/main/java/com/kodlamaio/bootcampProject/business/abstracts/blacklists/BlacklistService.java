package com.kodlamaio.bootcampProject.business.abstracts.blacklists;

import com.kodlamaio.bootcampProject.business.requests.blacklists.AddBlacklistRequest;
import com.kodlamaio.bootcampProject.business.requests.blacklists.UpdateBlacklistRequest;
import com.kodlamaio.bootcampProject.business.requests.bootcamps.AddBootcampRequest;
import com.kodlamaio.bootcampProject.business.requests.bootcamps.UpdateBootcampRequest;
import com.kodlamaio.bootcampProject.business.responses.blacklists.AddBlacklistResponse;
import com.kodlamaio.bootcampProject.business.responses.blacklists.GetAllBlacklistResponse;
import com.kodlamaio.bootcampProject.business.responses.blacklists.GetBlacklistResponse;
import com.kodlamaio.bootcampProject.business.responses.blacklists.UpdateBlacklistResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import javax.xml.crypto.Data;
import java.util.List;

public interface BlacklistService {
    DataResult<List<GetAllBlacklistResponse>> getAll();
    DataResult<GetBlacklistResponse> getById(int id);
    DataResult<AddBlacklistResponse> add(AddBlacklistRequest request);
    DataResult<UpdateBlacklistResponse> update(UpdateBlacklistRequest request);
    Result delete(int id);

    void checkIfApplicantInBlacklist(int applicantId);


}
