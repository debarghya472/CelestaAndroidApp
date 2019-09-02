package in.org.celesta.iitp.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.HashMap;
import java.util.Map;

import in.org.celesta.iitp.R;

public class HomeFragment extends Fragment {

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Map<Integer, Integer> map = new HashMap<>();

        map.put(R.id.main_pronite_ll, R.id.nav_pronite);
        map.put(R.id.main_event_ll, R.id.nav_events_cat);
        map.put(R.id.main_gallery_ll, R.id.nav_gallery);
        map.put(R.id.main_ongoing_ll, R.id.nav_ongoing);
        map.put(R.id.main_team_ll, R.id.nav_team);
        map.put(R.id.main_sponsor_ll, R.id.nav_sponsors);

        for (final Map.Entry<Integer, Integer> pair : map.entrySet()) {
            View mainView = view.findViewById(pair.getKey());
            mainView.setOnClickListener(v -> {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(pair.getValue());
            });
        }

//        View mainView = view.findViewById(R.id.main_event_ll);
//        mainView.setOnClickListener(v -> {
//            EventDetailsFragment fragment = new EventDetailsFragment();
//            fragment.show(requireActivity().getSupportFragmentManager(), fragment.getTag());
//        });

        return view;
    }
}
