package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.erick.breweryappnew.MainActivity;
import com.example.erick.breweryappnew.R;
import com.example.erick.breweryappnew.StringBuilderToBT;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SubPage3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SubPage3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SubPage3 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ToggleButton healingState;
    private EditText temperatureValue;
    private EditText timeValue;
    private Button runButton;
    private String savedHealingState;
    private StringBuilderToBT infoToBTModule;

    public SubPage3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SubPage3.
     */
    // TODO: Rename and change types and number of parameters
    public static SubPage3 newInstance(String param1, String param2) {
        SubPage3 fragment = new SubPage3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        healingState = (ToggleButton)getView().findViewById(R.id.toggleButton);
        temperatureValue = (EditText)getView().findViewById(R.id.editSetTempHM);
        timeValue = (EditText)getView().findViewById(R.id.editSetTimeHM);
        runButton = (Button)getView().findViewById(R.id.runHMButton);
        healingState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoToBTModule.setHealingState(healingState.isChecked() ? "ON" : "OFF");
            }
        });
        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoToBTModule = new StringBuilderToBT();
                infoToBTModule.setTime(timeValue.getText().toString());
                infoToBTModule.setTemperature(Integer.parseInt(temperatureValue.getText().toString()));
                Log.d("Run button", infoToBTModule.getAll());
                //TODO: send to BT module

                /*try {
                    OutputStream outStream = MainActivity.clientSocket.getOutputStream();
                    outStream.write(infoToBTModule.getAll().getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_sub_page3, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
