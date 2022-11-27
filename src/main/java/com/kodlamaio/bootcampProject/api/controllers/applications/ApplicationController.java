package com.kodlamaio.bootcampProject.api.controllers.applications;

import com.kodlamaio.bootcampProject.business.abstracts.applications.ApplicationService;
import com.kodlamaio.bootcampProject.business.requests.applications.AddApplicationRequest;
import com.kodlamaio.bootcampProject.business.requests.applications.UpdateApplicationRequest;
import com.kodlamaio.bootcampProject.business.responses.applications.AddApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.applications.GetAllApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.applications.GetApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.applications.UpdateApplicationResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    ApplicationService applicationService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllApplicationResponse>> getAll(){
        return applicationService.getAll();
    }

    @PostMapping("/add")
    public DataResult<AddApplicationResponse> add(@Valid @RequestBody AddApplicationRequest addApplicationRequest) {
        return applicationService.add(addApplicationRequest);
    }

    @PutMapping("/update")
    public DataResult<UpdateApplicationResponse> update  (@Valid @RequestBody UpdateApplicationRequest updateApplicationRequest) {
        return applicationService.update(updateApplicationRequest);
    }

    @DeleteMapping("/{id}")
    public Result delete (@PathVariable int id) {
        return applicationService.delete(id);
    }

    @GetMapping("/{id}")
    public DataResult<GetApplicationResponse> getById(@PathVariable int id){
        return applicationService.getById(id);
    }
}
