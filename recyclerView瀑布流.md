# RecyclerView 瀑布流
## 步骤：
* 使用 StaggeredGridLayoutManager
* staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS)
* 使用自定义的RecyclerView.ItemDecoration来设置间距
* RecyclerView 的 adapter.onBindViewHolder 方法中 手动设置item的高度

### 代码

#### ItemDecoration
```
public class StaggeredDividerItemDecoration extends RecyclerView.ItemDecoration {
    private Context context;
    private int interval;

    public StaggeredDividerItemDecoration(Context context, int interval) {
        this.context = context;
        this.interval = interval;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        int position = parent.getChildAdapterPosition(view);



        StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        // 获取item在span中的下标
        int spanIndex = params.getSpanIndex();
        int interval = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                this.interval, context.getResources().getDisplayMetrics());
        // 中间间隔
        if (spanIndex % 2 == 0) {
            outRect.left = 0;
        } else {
            // item为奇数位，设置其左间隔为5dp
            outRect.left = interval;
        }

        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if(childAdapterPosition == 0|| childAdapterPosition == 1){
            outRect.top = interval;
        }else {
            outRect.top = 0;
        }

        // 下方间隔
        outRect.bottom = interval;
    }
}
```
