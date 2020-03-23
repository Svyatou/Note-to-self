package com.example.notetoself;

import org.json.JSONException;
import org.json.JSONObject;

public class Note {

    private static final String JSON_TITLE = "title";
    private static final String JSON_DESCRIPTION = "description";
    private static final String JSON_IDEA = "idea";
    private static final String JSON_TODO = "todo";
    private static final String JSON_IMPORTANT = "important";

    private String title;
    private String description;
    private boolean idea;
    private boolean todo;
    private boolean important;

    public Note(JSONObject jo) throws JSONException {
        title = jo.getString(JSON_TITLE);
        description = jo.getString(JSON_DESCRIPTION);
        idea = jo.getBoolean(JSON_IDEA);
        todo = jo.getBoolean(JSON_TODO);
        important = jo.getBoolean(JSON_IMPORTANT);
    }

    public Note() {
    }

    public JSONObject converToJson() throws JSONException {
    JSONObject jo = new JSONObject();

    jo.put(JSON_TITLE, title);
    jo.put(JSON_DESCRIPTION, description);
    jo.put(JSON_IDEA, idea);
    jo.put(JSON_TODO, todo);
    jo.put(JSON_IMPORTANT, important);

    return jo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdea(boolean idea) {
        this.idea = idea;
    }

    public void setTodo(boolean todo) {
        this.todo = todo;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isIdea() {
        return idea;
    }

    public boolean isTodo() {
        return todo;
    }

    public boolean isImportant() {
        return important;
    }
}
