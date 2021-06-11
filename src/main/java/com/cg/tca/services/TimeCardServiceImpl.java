/**package com.cg.tca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tca.entities.Attendance;
import com.cg.tca.entities.TimeCard;
import com.cg.tca.exception.ResourceNotFoundException;
import com.cg.tca.repository.EmployeeRepository;
import com.cg.tca.repository.TimeCardRepository;

@Service
public class TimeCardServiceImpl implements TimeCardService {

	@Autowired
	TimeCardRepository daoCaller;

	@Autowired
	public EmployeeRepository employeeRepository;

	@Override
	public TimeCard saveTimeEntry(TimeCard timeCard) {
		return daoCaller.save(timeCard);
	}

	@Override
	public TimeCard getTimeCard(Integer tcId) {
		TimeCard opt = null;
		if (daoCaller.findById(tcId).isPresent()) {
			opt = daoCaller.findById(tcId).get();
		}
		return opt;
	}

	@Override
	public boolean removeEntry(int timeCardId) throws ResourceNotFoundException {
		boolean check = false;
		TimeCard toDelete = daoCaller.findById(timeCardId)
				.orElseThrow(() -> new ResourceNotFoundException("TimeCard not found for this id :: " + timeCardId));
		check = (toDelete != null);
		daoCaller.deleteById(timeCardId);
		return check;
	}

	@Override
	public int updateTimeCardById(Integer timeCardId, TimeCard tcard) throws ResourceNotFoundException {
		TimeCard tca = daoCaller.findById(timeCardId).orElseThrow(
				() -> new ResourceNotFoundException("Attendance not found for this id :: " + timeCardId));
	    tca.setDate(tca.getDate());
		tca.setTimeEntry(tca.getTimeEntry());
		tca.setTimeExit(tca.getTimeExit());
		tca.setStatus(tca.getStatus());
		daoCaller.save(tca);
		return tca.getTimeCardId();
	}

	
	
	@Override
	public List<TimeCard> displayAll() {
		return daoCaller.findAll();
	}

}**/

package com.cg.tca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tca.entities.Employee;
import com.cg.tca.entities.TimeCard;
import com.cg.tca.exception.ResourceNotFoundException;
import com.cg.tca.repository.TimeCardRepository;

@Service
public class TimeCardServiceImpl implements TimeCardService {

	@Autowired
	private TimeCardRepository tcdetails;

	@Override
	public TimeCard create(TimeCard tc) {
		return tcdetails.save(tc);
	}

	@Override
	public TimeCard getTimeCardById(int timeCardId) throws ResourceNotFoundException {
		TimeCard tc = tcdetails.findById(timeCardId).orElseThrow(
				() -> new ResourceNotFoundException("TimeCard not found for this id :: " + timeCardId));
		return tc;
	}

	@Override
	public List<TimeCard> getAllTimeCard() {
		return tcdetails.findAll();
	}

	@Override
	public boolean deleteTimeCardById(Integer timeCardId) throws ResourceNotFoundException {
		TimeCard timeCard = tcdetails.findById(timeCardId).orElseThrow(
				() -> new ResourceNotFoundException("TimeCard not found for this id :: " + timeCardId));
		tcdetails.delete(timeCard);
		return true;
	}

	@Override
	public TimeCard saveTimeCard(TimeCard tc) {
		return tcdetails.save(tc);
	}
	
	@Override
	public int updateTimeCardById(Integer timeCardId, TimeCard tcard) throws ResourceNotFoundException {
		TimeCard tca = tcdetails.findById(timeCardId).orElseThrow(
				() -> new ResourceNotFoundException("Attendance not found for this id :: " + timeCardId));
	    tca.setDate(tca.getDate());
		tca.setTimeEntry(tca.getTimeEntry());
		tca.setTimeExit(tca.getTimeExit());
		tca.setStatus(tca.getStatus());
		tcdetails.save(tca);
		return tca.getTimeCardId();
	}

}
