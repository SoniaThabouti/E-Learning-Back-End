package ElearningBack.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity

@Data
@Table(name="events")
@AllArgsConstructor
public class SchoolEvent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvent;
    
    @Column(name="dayEvent")
    @NotNull
    private String dayEvent;
    
    @Column(name="monthEvent")
    @NotEmpty
    private String monthEvent;


    @Column(name="Duration")
    @NotEmpty
    private String Duration;
    @Column(name="description")
    @NotEmpty
    private String Description;
    @Column(name="link")
    @NotEmpty
    private String Link;
    @Column(name="yearEvent")
    @NotNull
    private Long yearEvent;
    @Column(name="nameEvent")
    @NotEmpty
    private String nameEvent;


    public  SchoolEvent() {
        super();
    }

    public SchoolEvent(Long idEvent, String dayEvent, String monthEvent, String description, String link, String nameEvent, String Duration , Long yearEvent) {
       this.idEvent = idEvent;
        this.dayEvent = dayEvent;
        this.monthEvent = monthEvent;
     this.yearEvent = yearEvent;
        this.Description = description;
        this.Link = link;
        this.nameEvent=nameEvent;
        this.Duration=Duration;
    }





    public String getDayEvent() {
        return dayEvent;
    }

    public void setDayEvent(String dayEvent) {
        this.dayEvent = dayEvent;
    }

    public String getMonthEvent() {
        return monthEvent;
    }

    public void setMonthEvent(String monthEvent) {
        this.monthEvent = monthEvent;
    }

    public Long getYearEvent() {
        return yearEvent;
    }

    public void setYearEvent(Long yearEvent) {
        this.yearEvent = yearEvent;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        this.Link = link;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String Duration) {
        Duration = Duration;
    }


	
	

}
