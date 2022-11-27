package com.powafinance.persistence.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * helpful articles:
     * - https://www.jpa-buddy.com/blog/the-ultimate-guide-on-db-generated/
     * - https://stackoverflow.com/a/66936685/16543524
     */

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    private UUID id;

    @Column(name = "username", nullable = false, length = 140, unique = true)
    private String userName;

    @Column(nullable = false, length = 120, unique = true)
    private String email;

    @Column(name = "passhash", nullable = false, length = 500)
    private String passHash;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<ExpenseTable> allExpens;
}
