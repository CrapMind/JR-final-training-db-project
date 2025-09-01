package dev.subotinov.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;

@Entity
@Table (schema = "world", name = "country_language")
@Getter @Setter
public class CountryLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @Column(name = "language", length = 30, nullable = false)
    private String language;
    @Column(name = "is_official", columnDefinition = "BIT", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean isOfficial;
    @Column(name = "percentage", nullable = false, columnDefinition = "decimal(4,1)")
    private BigDecimal percentage;
}
