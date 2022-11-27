package com.kodlamaio.bootcampProject.api.controllers.blacklists;

import com.kodlamaio.bootcampProject.business.abstracts.blacklists.BlacklistService;
import com.kodlamaio.bootcampProject.business.requests.blacklists.AddBlacklistRequest;
import com.kodlamaio.bootcampProject.business.requests.blacklists.UpdateBlacklistRequest;
import com.kodlamaio.bootcampProject.business.responses.blacklists.AddBlacklistResponse;
import com.kodlamaio.bootcampProject.business.responses.blacklists.GetAllBlacklistResponse;
import com.kodlamaio.bootcampProject.business.responses.blacklists.GetBlacklistResponse;
import com.kodlamaio.bootcampProject.business.responses.blacklists.UpdateBlacklistResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/blacklists")
public class BlacklistController {
    private BlacklistService blacklistService;

    @GetMapping
    DataResult<List<GetAllBlacklistResponse>> getAll() {
        return blacklistService.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    DataResult<AddBlacklistResponse> add(@Valid @RequestBody AddBlacklistRequest request) {
        return blacklistService.add(request);
    }

    @GetMapping("/{id}")
    DataResult<GetBlacklistResponse> getById(@PathVariable int id) {
        return blacklistService.getById(id);
    }

    @PutMapping("/{id}")
    DataResult<UpdateBlacklistResponse> update(@Valid @RequestBody UpdateBlacklistRequest request) {
        return blacklistService.update(request);
    }

    @DeleteMapping("/{id}")
    Result delete(@PathVariable int id) {
        return blacklistService.delete(id);
    }

}
