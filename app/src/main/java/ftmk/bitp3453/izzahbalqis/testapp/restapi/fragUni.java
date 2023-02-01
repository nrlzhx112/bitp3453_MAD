/**package ftmk.bitp3453.izzahbalqis.testapp.restapi;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
//import ftmk.bitp3453.izzahbalqis.testapp.restapi.databinding.fragUniBinding;//

    /**
     * A simple {@link Fragment} subclass.
     * Use the {@link fragUni#newInstance} factory method to
     * create an instance of this fragment.
     */
    public class fragUni extends Fragment {

        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";

        // TODO: Rename and change types of parameters
        private String mParam1;
        private String mParam2;

        public fragUni() {
            // Required empty public constructor
        }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GetUniversityFrag.
         */
        // TODO: Rename and change types and number of parameters
        public static fragUni newInstance(String param1, String param2) {
            fragUni fragment = new fragUni();
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
        }
/**
        fragUniBinding binding;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            //return inflater.inflate(R.layout.fragment_get_university, container, false);
            binding = fragUniBinding.inflate(inflater,container, false);
            binding.btnSearchU.setOnClickListener(this::fnSearchUni);
            return binding.getRoot();
        }

        private void fnSearchUni(View view) {
            String strURl = "http://universities.hipolabs.com/search?contry="+
                    binding.edtFindUniversity.getText().toString() + "&name=" + binding.edtUniName.getText().toString();
            RequestQueue requestQueue= Volley.newRequestQueue(getContext());
            StringRequest stringRequest = new StringRequest(Request.Method.GET, strURl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    binding.results.setText(response);
                    binding.results.setMovementMethod(new ScrollingMovementMethod());

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(getContext(),"Unable to get university list!" + error.getMessage(), Toast.LENGTH_SHORT).show();
                }

            });
            requestQueue.add(stringRequest);
        } */
    }

