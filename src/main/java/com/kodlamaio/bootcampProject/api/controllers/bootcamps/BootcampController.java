package com.kodlamaio.bootcampProject.api.controllers.bootcamps;

import com.kodlamaio.bootcampProject.business.abstracts.bootcamps.BootcampService;
import com.kodlamaio.bootcampProject.business.requests.bootcamps.AddBootcampRequest;
import com.kodlamaio.bootcampProject.business.requests.bootcamps.UpdateBootcampRequest;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.AddBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.GetAllBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.GetBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.UpdateBootcampResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/bootcamps")
public class BootcampController {
    BootcampService bootcampService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllBootcampResponse>> getAll(){
        return bootcampService.getAll();
    }

    @PostMapping("/add")
    public DataResult<AddBootcampResponse> add(@RequestBody AddBootcampRequest addBootcampRequest) {
        return bootcampService.add(addBootcampRequest);
    }

    @PutMapping("/update")
    public DataResult<UpdateBootcampResponse> update  (@RequestBody UpdateBootcampRequest updateBootcampRequest) {
        return bootcampService.update(updateBootcampRequest);
    }

    @DeleteMapping("/{id}")
    public Result delete (@PathVariable int id) {
        return bootcampService.delete(id);
    }

    @GetMapping("/{id}")
    public DataResult<GetBootcampResponse> getById(@PathVariable int id){
        return bootcampService.getById(id);
    }
}
