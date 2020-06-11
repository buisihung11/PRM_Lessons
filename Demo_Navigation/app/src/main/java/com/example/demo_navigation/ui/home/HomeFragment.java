package com.example.demo_navigation.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.demo_navigation.R;
import com.example.demo_navigation.daos.StudentAdapter;
import com.example.demo_navigation.daos.StudentDAO;
import com.example.demo_navigation.dtos.StudentDTO;

import java.io.InputStream;
import java.util.List;

public class HomeFragment extends Fragment {

    private ListView listViewStudent;
    private StudentAdapter studentAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        listViewStudent = root.findViewById(R.id.listViewStudent);
        studentAdapter = new StudentAdapter();
        InputStream is = this.getActivity().getResources().openRawResource(R.raw.data);
        StudentDAO dao = new StudentDAO();
        List<StudentDTO> result = dao.loadFromRaw(is);
        studentAdapter.setStudentDTOList(result);
        listViewStudent.setAdapter(studentAdapter);
        listViewStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StudentDTO dto = (StudentDTO) listViewStudent.getItemAtPosition(position);
                Toast.makeText(getActivity().getApplicationContext(), dto.toString(), Toast.LENGTH_LONG).show();
            }
        });
        return root;
    }
}
