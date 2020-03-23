package com.example.notetoself;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class JSONSerializer {

    private String filaName;
    private Context context;



    public JSONSerializer(String fileName, Context context){
        this.filaName = fileName;
        this.context = context;
    }

    public void save(List<Note> listNote) throws IOException, JSONException{

        JSONArray jsonArray = new JSONArray();

        for (Note note : listNote){
            jsonArray.put(note.converToJson());
        }

        Writer writer = null;
        try {
            OutputStream out = context.openFileOutput(filaName, context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(jsonArray.toString());
        }
        finally {
            if (writer != null){
                writer.close();
            }
        }

    }

    public ArrayList<Note> load() throws IOException, JSONException {
        ArrayList<Note> listNote = new ArrayList<>();

        BufferedReader reader = null;
        try {
            InputStream in = context.openFileInput(filaName);

            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();


            String line = null;
            while ((line = reader.readLine()) != null) ;
            {
                jsonString.append(line);
            }

            JSONArray jsonArray = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
            for (int i = 0; i < jsonArray.length(); i++) {
                listNote.add(new Note(jsonArray.getJSONObject(i)));
            }
        }
        catch (FileNotFoundException e) {
            //
        }
        finally {
            if (reader != null){
                reader.close();
            }
        }
        return listNote;
        }
    }

