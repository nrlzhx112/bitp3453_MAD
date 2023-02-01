package ftmk.bitp3453.izzahbalqis.testapp.restapi;

mport androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class fragAdapter extends FragmentStateAdapter{

    public fragAdapter (@NonNull FragmentActivity fragActivity) {
        super(fragActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1 :
                return  new fragUni();
            case 0:
                return new fragActivity();
            default:
                return new fragActivity();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}