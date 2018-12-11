package org.hibernate.bugs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class DatesTbl {

    @Column(columnDefinition = "DATETIME", nullable = false)
    @Id
    private LocalDateTime creationDate;

    public DatesTbl() {
    }
    public DatesTbl(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

}

