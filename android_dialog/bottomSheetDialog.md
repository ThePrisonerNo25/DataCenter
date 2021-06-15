
# BottomSheetDialogFragment小技巧
```
public class CustomBottomSheetDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //Set the background transparent to display the layout such as rounded corners in the layout, otherwise there will be a white background (frame)
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.spec_bottom_sheet, container, false);
        return rootView;
    }
}


    <style name="CustomBottomSheetDialogTheme" parent="Theme.Design.Light.BottomSheetDialog">
        <item name="bottomSheetStyle">@style/CustomBottomSheetStyle</item>
    </style>

    <style name="CustomBottomSheetStyle" parent="Widget.Design.BottomSheet.Modal">
        <item name="android:background">@android:color/transparent</item>
    </style>
```
