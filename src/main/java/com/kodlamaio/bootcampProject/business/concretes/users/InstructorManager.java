package com.kodlamaio.bootcampProject.business.concretes.users;

import java.util.List;
import java.util.stream.Collectors;

import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.users.InstructorService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.intructors.AddInstructorRequest;
import com.kodlamaio.bootcampProject.business.requests.intructors.UpdateInstructorRequest;
import com.kodlamaio.bootcampProject.business.responses.instructors.AddInstructorResponse;
import com.kodlamaio.bootcampProject.business.responses.instructors.GetAllInstructorResponse;
import com.kodlamaio.bootcampProject.business.responses.instructors.GetInstructorResponse;
import com.kodlamaio.bootcampProject.business.responses.instructors.UpdateInstructorResponse;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.users.InstructorRepository;
import com.kodlamaio.bootcampProject.entities.users.Instructor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InstructorManager implements InstructorService{

	private InstructorRepository instructorRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult <AddInstructorResponse> add(AddInstructorRequest addInstructorRequest) {
		Instructor instructor = this.modelMapperService.forRequest().map(addInstructorRequest, Instructor.class);
		checkIfInstructorExistsByNationalId(instructor.getNationalId());
		this.instructorRepository.save(instructor);
		AddInstructorResponse addInstructorResponse = this.modelMapperService.forResponse().map(instructor, AddInstructorResponse.class);
		return new SuccessDataResult<AddInstructorResponse>(addInstructorResponse, Messages.InstructorCreated);
	}

	@Override
	public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest) {
		Instructor instructor = this.modelMapperService.forRequest().map(updateInstructorRequest, Instructor.class);
		checkIfInstructorExistsById(instructor.getId());
		this.instructorRepository.save(instructor);
		UpdateInstructorResponse updateInstructorResponse = this.modelMapperService.forResponse().map(instructor, UpdateInstructorResponse.class);
		return new SuccessDataResult<UpdateInstructorResponse>(updateInstructorResponse, Messages.InstructorUpdated);
	}

	@Override
	public Result delete(int id) {
		checkIfInstructorExistsById(id);
		this.instructorRepository.deleteById(id);
		return new SuccessResult(Messages.InstructorDeleted);
	}

	@Override
	public DataResult<List<GetAllInstructorResponse>> getAll() {
		List<Instructor> instructors = instructorRepository.findAll();
		List<GetAllInstructorResponse> response = instructors.stream()
				.map(instructor->this.modelMapperService.forResponse().map(instructor, GetAllInstructorResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllInstructorResponse>>(response);
	}

	@Override
	public DataResult<GetInstructorResponse> getById(int id) {
		Instructor instructor = this.instructorRepository.findById(id).get();
		GetInstructorResponse response = this.modelMapperService.forResponse().map(instructor, GetInstructorResponse.class);
		return new SuccessDataResult<GetInstructorResponse>(response);
	}
	private void checkIfInstructorExistsByNationalId(String nationalId){
		Instructor instructor=instructorRepository.findByNationalId(nationalId);
		if(instructor!=null) throw new BusinessException(Messages.InstructorExists);

	}
	private void checkIfInstructorExistsById(int id){
		Instructor instructor=instructorRepository.findById(id).get();
		if(instructor!=null) throw new BusinessException(Messages.InstructorExists);
	}
}
