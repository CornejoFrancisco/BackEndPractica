package com.bda.carrental.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicules")
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Vehicle {
    @Id
    @GeneratedValue(generator = "vehicles")
    @TableGenerator(name = "vehicles", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="vehicles",
            initialValue=1, allocationSize=1)

    private long id;

    @Column(name = "year_model")
    private Integer yearmodel;

    @Column(name = "brand_name")
    private String brandname;

    private Integer compact;

    @Column(name = "driver_name")
    private String drivername;

    @Column(name = "cost_hour")
    private Double costhour;

    @Column(name = "total_miles")
    private Integer totalmiles;

    @OneToMany(mappedBy = "vehicleId", fetch = FetchType.LAZY)
    private List<CarRentalDetails> carRentalDetailsList;


}
