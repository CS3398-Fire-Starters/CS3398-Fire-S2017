package com.example.derek.workouttracker20;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileReaderWriter {

    private Context context;

    public FileReaderWriter(Context context){
        this.context=context;
    }

    public void loginCreate(String dir, String user, String pass, String accountDetails){

        String line = "";
        String root = Environment.getExternalStorageDirectory().toString();
        File fDir = new File(root + "/workouttracker20/"+dir);
        fDir.mkdirs();
        File file = new File(fDir, "loginSheet.txt");
        boolean check = false;

        try {
            if (!file.exists()) {
                PrintWriter pw = new PrintWriter("loginSheet.txt");
                pw.close();
            }
        } catch (IOException e){

        }
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);

            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                if (line.contains((user + ':')) ){
                    check = true;
                    break;
                }
            }
            br.close();
            //Username already exists
            if (check == true) {
                out.close();
                return;
            }
            //username doesnt exist
            if (check == false) {
                String fileName = (user + '_' + pass + ".txt");
                String dataOut = (user + ':' + pass + ' ' + fileName);
                File detailFile = new File(fDir, fileName);
                out.println(dataOut);
                out.close();
                if (!detailFile.exists()) {
                    PrintWriter pw = new PrintWriter(detailFile);
                    pw.println(accountDetails);
                    pw.close();
                }
            }

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    public String loginCheck(String dir,  String user, String pass){

        String line = "";
        String temp = (user + ':' + pass);

        String root = Environment.getExternalStorageDirectory().toString();
        File fDir = new File(root + "/workouttracker20/"+dir);
        fDir.mkdirs();
        File file = new File(fDir, "loginSheet.txt");

        try{
            if (file.exists())
            {
                BufferedReader br = new BufferedReader(new FileReader(file));
                while((line = br.readLine()) != null)
                {
                    if (line.contains(temp))
                    {
                        String temp2 = line;
                        String temp3[] = line.split(" ");
                        br.close();
                        return temp3[1];

                    }
                }
                br.close();
            }
        } catch (FileNotFoundException e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
            return "";
        } catch (IOException e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
            return "";
        }
        return null;
    }

    public Boolean loginVerify(String dir,  String user, String pass){

        String line = "";
        String temp = (user + ':' + pass);

        String root = Environment.getExternalStorageDirectory().toString();
        File fDir = new File(root + "/workouttracker20/"+dir);
        fDir.mkdirs();
        File file = new File(fDir, "loginSheet.txt");

        try{
            if (file.exists()) {

                BufferedReader br = new BufferedReader(new FileReader(file));

                while((line = br.readLine()) != null){
                    if (line.contains(temp)) {
                        br.close();
                        return true;



                    }
                }
                br.close();

            }

        } catch (FileNotFoundException e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
        }

        return false;
    }

    //this does login check then pulls filename matching
    public ArrayList<String> accountDetailsObtain(String dir, String user, String pass) {
        String fileName = loginCheck(dir, user, pass), line = "", temp = ".txt";

        ArrayList<String> arr = new ArrayList<>();

        String root = Environment.getExternalStorageDirectory().toString();
        File fDir = new File(root + "/workouttracker20/"+dir);
        fDir.mkdirs();

        File file = new File(fDir, fileName);


        try{
            if (file.exists()) {

                BufferedReader br = new BufferedReader(new FileReader(file));

                // reads till the end of the stream
                while((line = br.readLine()) != null){
                    if (line.contains(temp)) {
                        // this where adds array list
                        //this is where you obtain all file names
                        arr.add(line);
                    }
                }
                br.close();
            }

        } catch (FileNotFoundException e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
        }

        return arr;

    }

    //this is supposed to be when you create a restaurant
    public void accountDetailsAppend(String dir, String user, String pass, String fileNameAppend) throws IOException{
        boolean check = false;

        String root = Environment.getExternalStorageDirectory().toString();
        File fDir = new File(root + "/workouttracker20/"+dir);
        fDir.mkdirs();

        String fileName = loginCheck(dir, user, pass), line = "";

        if (fileName == null) {

            System.out.println("login does not exist");
            return;
        }

        File file = new File(fDir, fileName);
        try {

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);

            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                if (line.contains(fileNameAppend)) {
                    check = true;
                    break;
                }
            }
            br.close();
            //filename already exsists
            if (check == true) {
                out.close();
                return;
            }

            //username doesnt exist
            if (check == false) {
                out.println(fileNameAppend);
                searchAppend(dir, fileNameAppend);
            }
            out.close();
        }
        catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    public void accountDetailsRemove(String dir, String user, String pass, String fileNameRemove) throws IOException{

        String root = Environment.getExternalStorageDirectory().toString();
        File fDir = new File(root + "/workouttracker20/"+dir);
        fDir.mkdirs();

        String fileName = loginCheck(dir, user, pass);
        if (fileName == null) {
            System.out.println("login does not exist");
            return;
        }
        File inputFile = new File(fDir, fileName);
        File tempFile = new File(fDir, "myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = fileNameRemove;
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(lineToRemove)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));

        }
        searchRemove(dir, fileNameRemove);
        writer.close();
        reader.close();
        inputFile.delete();
        tempFile.renameTo(inputFile);
    }

    public void searchAppend(String dir, String fileNameAppend) throws IOException{
        boolean check = false;
        String root = Environment.getExternalStorageDirectory().toString();
        File fDir = new File(root + "/workouttracker20/"+dir);
        fDir.mkdirs();

        String line = "";

        File file = new File(fDir, "searchStorage.txt");
        if (!file.exists()) {
            PrintWriter pw = new PrintWriter(file);
            pw.close();
        }

        try {

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);

            //checks if filename already in searchStorage.txt
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                if (line.contains(fileNameAppend)) {
                    check = true;
                    break;
                }
            }

            br.close();

            //Username already exists
            if (check == true) {
                out.close();
                return;
            }

            //username doesnt exist
            if (check == false) {
                out.println(fileNameAppend + "<0_0");

            }
            out.close();
        }
        catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    public void searchRemove(String dir, String fileNameRemove) throws IOException{
        String root = Environment.getExternalStorageDirectory().toString();
        File fDir = new File(root + "/workouttracker20/"+dir);
        fDir.mkdirs();
        File inputFile = new File(fDir, "searchStorage.txt");
        File tempFile = new File(fDir, "myTempSearch.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = fileNameRemove;
        String currentLine;

        while((currentLine = reader.readLine()) != null) {

            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(trimmedLine.contains(lineToRemove)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        inputFile.delete();
        tempFile.renameTo(inputFile);
    }

    public void replaceRating(String dir, String fileNameRemove, String newRating) throws IOException{
        String root = Environment.getExternalStorageDirectory().toString();
        File fDir = new File(root + "/workouttracker20/"+dir);
        fDir.mkdirs();
        File inputFile = new File(fDir, "searchStorage.txt");
        File tempFile = new File(fDir, "myTempSearch.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = fileNameRemove;
        String currentLine;

        while((currentLine = reader.readLine()) != null) {

            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(trimmedLine.contains(lineToRemove)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        String replaceEntry = (fileNameRemove + '<' + newRating);
        writer.write(replaceEntry + System.getProperty("line.separator"));
        writer.close();
        reader.close();
        inputFile.delete();
        tempFile.renameTo(inputFile);
    }

    public String mFileReader(String dir, String filename){

        String line = "";
        int i = 0;

        String root = Environment.getExternalStorageDirectory().toString();
        File fDir = new File(root + "/workouttracker20/"+dir);
        fDir.mkdirs();
        File file = new File(fDir, filename);

        try{
            if (file.exists()) {

                BufferedReader br = new BufferedReader(new FileReader(file));

                // reads till the end of the stream
                while((i = br.read())!=-1) {

                    line = (line + (char)i);
                }
                br.close();
            }
        } catch (FileNotFoundException e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
            return "";
        } catch (IOException e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
            return "";
        }

        return line;
    }

    public void mFileWriter(String dir, String filename, String ext, String output){

        if(ext.equals(null) || ext.equals("")){
            ext = ".txt";
        }

        if(filename.equals(null) || filename.equals("")){
            Toast.makeText(context, "No File Name Declared!", Toast.LENGTH_LONG).show();
        } else {

            String root = Environment.getExternalStorageDirectory().toString();
            File fDir = new File(root + "/otm/"+dir);
            fDir.mkdirs();
            File file = new File(fDir, filename+ext);

            try{
                FileOutputStream out = new FileOutputStream(file);
                PrintWriter write = new PrintWriter(out);
                write.println(output);
                write.flush();
                write.close();
                out.close();
            } catch (FileNotFoundException e){
                Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
            } catch (IOException e){
                Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
            }

        }
    }

    public void mDirDelete(String dir){

        String root = Environment.getExternalStorageDirectory().toString();
        File fDir = new File(root+"/workouttracker20/"+dir);

        if(fDir.isDirectory()){
            String[] children = fDir.list();
            for(int i=0; i<children.length; i++){
                new File(fDir, children[i]).delete();
            }
        }

    }

    public boolean mDirChecker(String dir){

        String root = Environment.getExternalStorageDirectory().toString();
        File file = new File(root+"/otm/"+dir);
        File[] contents = file.listFiles();

        if(contents == null){
            return false;
        } else if(contents.length == 0){
            return false;
        } else {
            return true;
        }

    }

    public void delFile(String dir, String filename){
        String root = Environment.getExternalStorageDirectory().toString();
        File fDir = new File(root+"/workouttracker20/"+dir);
        File file = new File(fDir, filename);

        file.delete();

    }


    // Check if External Storage is Readable/Writable
    public boolean isExternalStorageReadable(){

        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            return true;
        }

        return false;
    }
    public boolean isExternalStorageWritable(){

        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            return true;
        }

        return false;
    }
}
