package spg.pre.microservices.calendar.fileAccess;

import java.time.LocalDate;
import java.util.Objects;

public class Note {

    private String id;

    private String title;

    private String description;

    private LocalDate calendarDate;

    public Note(String id, String title, String description, LocalDate calendarDate){

        this.id = id;

        this.title=title;

        this.description=description;

        this.calendarDate=calendarDate;

    }

    public String getId() {
        return id;
    }

    protected void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCalendarDate() {
        return calendarDate;
    }

    protected void setCalendarDate(LocalDate calendarDate) {
        this.calendarDate = calendarDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(title, note.title) && Objects.equals(description, note.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, calendarDate);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", calendarDate=" + calendarDate +
                '}';
    }
}
