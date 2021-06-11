/**package com.cg.tca.services;

import java.util.List;

import com.cg.tca.entities.TimeCard;
import com.cg.tca.exception.ResourceNotFoundException;

public interface TimeCardService {

	TimeCard saveTimeEntry(TimeCard sup);

	boolean removeEntry(int timeCardId) throws ResourceNotFoundException;

	public int updateTimeCardById(Integer timeCardid, TimeCard tcard) throws ResourceNotFoundException;

	List<TimeCard> displayAll();

	TimeCard getTimeCard(Integer tcId);

}**/

package com.cg.tca.services;

import java.util.List;

import com.cg.tca.entities.TimeCard;
import com.cg.tca.exception.ResourceNotFoundException;

public interface TimeCardService {

	public List<TimeCard> getAllTimeCard();

	int  updateTimeCardById(Integer timeCardId, TimeCard tc) throws ResourceNotFoundException;

	TimeCard getTimeCardById(int timeCardId) throws ResourceNotFoundException;

	boolean deleteTimeCardById(Integer timeCardId) throws ResourceNotFoundException;

	public TimeCard create(TimeCard tc);

	public TimeCard saveTimeCard(TimeCard tc);
}