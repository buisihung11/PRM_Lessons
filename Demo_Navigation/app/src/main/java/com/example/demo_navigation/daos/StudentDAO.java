package com.example.demo_navigation.daos;

import com.example.demo_navigation.dtos.StudentDTO;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements Serializable {
    public StudentDAO() {
    }

    public List<StudentDTO> loadFromRaw(InputStream is) {
        List<StudentDTO> result = new ArrayList<>();
        StudentDTO dto = null;
        BufferedReader br = null;
        InputStreamReader isr = null;
        String s = null;

        try {
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            while ((s = br.readLine()) != null) {
                String[] tmp = s.split("-");
                dto = new StudentDTO(tmp[0], tmp[1], Float.parseFloat(tmp[2]));
                result.add(dto);
            }
        } catch (Exception err) {

        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
            } catch (Exception err) {
                err.printStackTrace();
            }
        }

        return result;
    }

    public void saveToInternal(FileOutputStream fos, List<StudentDTO> list) {
        OutputStreamWriter osw = null;
        try {
            osw = new OutputStreamWriter(fos);
            for (StudentDTO student : list) {
                osw.append(student.getId() + "-" + student.getName() + "-" + student.getMark() + "\n");
            }
            osw.flush();
        } catch (Exception err) {

        } finally {
            try {
                if(osw != null)
                    osw.close();
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
    }

}

