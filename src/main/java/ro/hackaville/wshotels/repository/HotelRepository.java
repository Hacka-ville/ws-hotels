package ro.hackaville.wshotels.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import ro.hackaville.wshotels.model.entity.Hotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, String> {

    @Query("""
                SELECT F FROM Hotel F
                WHERE F.id = :id
            """)
    Optional<Hotel> getHotelById(@NonNull final String id);

    @Query("""
                SELECT F FROM Hotel F
                WHERE (:cityLocation = '' OR F.location.city = :cityLocation)
                AND (F.rooms >= :startDate AND F.hotelInformations.date <= :endDate)
                AND F.price BETWEEN :minPrice AND :maxPrice
                AND (:flightOperator = '' OR F.operator.name = :flightOperator)
                AND (F.hotelInformations.flightHour >= :flightHourStart AND F.hotelInformations.flightHour <= :flightHourEnd)
                AND (F.hotelInformations.arriveHour >= :arriveHourStart AND F.hotelInformations.flightHour <= :arriveHourEnd)
                ORDER BY :orderBy ASC
            """)
    List<Hotel> getFlightsByFiltersOrderbyAsc(@NonNull final LocalDate startDate,
                                              @NonNull final LocalDate endDate,
                                              final String flightLocation,
                                              final String arriveLocation,
                                              final String flightOperator,
                                              final BigDecimal minPrice,
                                              final BigDecimal maxPrice,
                                              final LocalTime flightHourStart,
                                              final LocalTime flightHourEnd,
                                              final LocalTime arriveHourStart,
                                              final LocalTime arriveHourEnd,
                                              final String orderBy,
                                              final Pageable pageable);

    @Query("""
                SELECT F FROM Hotel F
                WHERE ((:flightLocation = '' OR F.location.flightLocation = :flightLocation) AND
                (:arriveLocation = '' OR F.location.arriveLocation = :arriveLocation))
                AND (F.hotelInformations.date >= :startDate AND F.hotelInformations.date <= :endDate)
                AND F.price BETWEEN :minPrice AND :maxPrice
                AND (:flightOperator = '' OR F.operator.name = :flightOperator)
                AND (F.hotelInformations.flightHour >= :flightHourStart AND F.hotelInformations.flightHour <= :flightHourEnd)
                AND (F.hotelInformations.arriveHour >= :arriveHourStart AND F.hotelInformations.flightHour <= :arriveHourEnd)
                ORDER BY :orderBy DESC
            """)
    List<Hotel> getFlightsByFiltersOrderbyDesc(@NonNull final LocalDate startDate,
                                               @NonNull final LocalDate endDate,
                                               final String flightLocation,
                                               final String arriveLocation,
                                               final String flightOperator,
                                               final BigDecimal minPrice,
                                               final BigDecimal maxPrice,
                                               final LocalTime flightHourStart,
                                               final LocalTime flightHourEnd,
                                               final LocalTime arriveHourStart,
                                               final LocalTime arriveHourEnd,
                                               final String orderBy,
                                               final Pageable pageable);

    @Query("""
                SELECT F FROM Hotel F
                WHERE ((:flightLocation = '' OR F.location.flightLocation = :flightLocation) AND
                (:arriveLocation = '' OR F.location.arriveLocation = :arriveLocation))
                AND (F.hotelInformations.date >= :startDate AND F.hotelInformations.date <= :endDate)
                AND F.price BETWEEN :minPrice AND :maxPrice
                AND (:flightOperator = '' OR F.operator.name = :flightOperator)
                AND (F.hotelInformations.flightHour >= :flightHourStart AND F.hotelInformations.flightHour <= :flightHourEnd)
                AND (F.hotelInformations.arriveHour >= :arriveHourStart AND F.hotelInformations.flightHour <= :arriveHourEnd)
            """)
    List<Hotel> getFlightsByFilters(@NonNull final LocalDate startDate,
                                    @NonNull final LocalDate endDate,
                                    final String flightLocation,
                                    final String arriveLocation,
                                    final String flightOperator,
                                    final BigDecimal minPrice,
                                    final BigDecimal maxPrice,
                                    final LocalTime flightHourStart,
                                    final LocalTime flightHourEnd,
                                    final LocalTime arriveHourStart,
                                    final LocalTime arriveHourEnd,
                                    final Pageable pageable);

}
