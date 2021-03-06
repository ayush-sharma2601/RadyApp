package com.example.radyapp.PatientSide.FragmentsP;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.DoctorSide.ResponseModels.PrescriptionModel;
import com.example.radyapp.PatientSide.AdaptersP.PatientAppointmentAdapter;
import com.example.radyapp.PatientSide.ModelsP.CustomDialogClass;
import com.example.radyapp.PatientSide.ModelsP.PatientApppointmentModel;
import com.example.radyapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class PatientAppointmentFragment extends Fragment {
    View view;
    RecyclerView appointmentsRv;
    PatientAppointmentAdapter appointmentsAdapter;
    ArrayList<PatientApppointmentModel> patientAppointmentModels;
    ArrayList<PrescriptionModel> prescriptionModels;
    FloatingActionButton addApp;

    public PatientAppointmentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_patient_appointments, container, false);

        attachId();

        attachLayout();

        initArrayList();

        addData();

        initAdapter();

        attachAdapter();

        refreshAdapter();

        addApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialogClass dialogClass = new CustomDialogClass(view.getContext());
                dialogClass.show();
            }
        });

        return view;

    }

    private void attachAdapter() {

        appointmentsRv.setAdapter(appointmentsAdapter);
    }

    private void addData() {
        patientAppointmentModels.add(new PatientApppointmentModel("Dr Sharma","HOD, ENT",true,"Ward E-210","21/20/2001","4:10 PM","cough,cold"));
        patientAppointmentModels.add(new PatientApppointmentModel("Dr Bagga","HOD, ENT",true,"Ward F-96","21/20/2001","12:20 AM","hair loss"));
        patientAppointmentModels.add(new PatientApppointmentModel("Dr Bagga","Dental",false,"Ward E-210","21/20/2001","4:20 PM","ToothAche"));
            patientAppointmentModels.add(new PatientApppointmentModel("Dr Bagga","Gastro",false,"Ward E-210","21/20/2001","4:20 PM","bad stomach"));
    }



    private void refreshAdapter() {

        appointmentsAdapter.notifyDataSetChanged();
    }

    private void attachLayout() {
        appointmentsRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
    }

    private void initArrayList() {

        patientAppointmentModels=new ArrayList<>(3);
    }

    private void initAdapter() {
        appointmentsAdapter =new PatientAppointmentAdapter(patientAppointmentModels,prescriptionModels,0);
    }

    private void attachId() {
        appointmentsRv=view.findViewById(R.id.patient_appointments_rv1);
        addApp = view.findViewById(R.id.add_patient_appointment_fab);
    }
}