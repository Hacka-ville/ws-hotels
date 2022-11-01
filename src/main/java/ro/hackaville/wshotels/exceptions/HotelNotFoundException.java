package ro.hackaville.wshotels.exceptions;

import javax.persistence.EntityNotFoundException;

public class HotelNotFoundException extends EntityNotFoundException {

    public HotelNotFoundException(final String id) {
        super(String.format("Hotel with ID %s has not been found!", id));
    }
}
