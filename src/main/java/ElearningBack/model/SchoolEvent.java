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
<<<<<<< HEAD:src/main/java/ElearningBack/model/SchoolEvent.java
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
=======
public class Event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	String text;
	
	LocalDateTime start;
	
	LocalDateTime end;
	
	@ManyToOne
	@JsonIgnore
	TimeInterval TimeI;
	
	@JsonProperty("TimeI")
	public Long getTimeIntervalId() {
		return TimeI.getId();
	}
>>>>>>> 5f23b1afecb268b1dd3bf384061e2cfb1d91ecce:src/main/java/ElearningBack/model/Event.java

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

<<<<<<< HEAD:src/main/java/ElearningBack/model/SchoolEvent.java
    @Column(name="Duration")
    @NotEmpty
    private String Duration;

    public SchoolEvent() {
        super();
    }

    public SchoolEvent(Integer yearEvent, String dayEvent, String monthEvent, String description, String link, String nameEvent, String Duration) {
        this.dayEvent = dayEvent;
        this.monthEvent = monthEvent;
        this.yearEvent = yearEvent;
        this.description = description;
        this.link = link;
        this.nameEvent=nameEvent;
        this.Duration=Duration;
    }
=======
	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnd() {
		return end;
	}
>>>>>>> 5f23b1afecb268b1dd3bf384061e2cfb1d91ecce:src/main/java/ElearningBack/model/Event.java

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	public TimeInterval getTimeInterval() {
		return TimeI;
	}

<<<<<<< HEAD:src/main/java/ElearningBack/model/SchoolEvent.java
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

    public Integer getYearEvent() {
        return yearEvent;
    }

    public void setYearEvent(Integer yearEvent) {
        this.yearEvent = yearEvent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
=======
	public void setTimeInterval(TimeInterval TimeI) {
		this.TimeI = TimeI;
	}
	
	
>>>>>>> 5f23b1afecb268b1dd3bf384061e2cfb1d91ecce:src/main/java/ElearningBack/model/Event.java
}
