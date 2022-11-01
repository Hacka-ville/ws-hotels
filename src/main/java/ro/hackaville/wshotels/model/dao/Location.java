package ro.hackaville.wshotels.model.dao;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Location {

    @Builder.Default
    private String street = "";

    @Builder.Default
    private String number = "";

    private String city = "";
}
