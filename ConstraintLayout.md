# ConstraintLayout小技巧

1. 单行文本
 ```
<TextView
        android:id="@+id/tv_phone"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toRightOf="@+id/tv_name"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:layout_marginEnd="20dp"
        tools:text="18922023390"
        android:textSize="14sp"
        android:textColor="@color/color_white_translucent_30"
        />

    <TextView
        android:id="@+id/tv_name"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintRight_toLeftOf="@+id/tv_phone"
        app:layout_constraintHorizontal_bias="0"
        app:layout_constraintHorizontal_chainStyle="packed"
        app:layout_constrainedWidth="true"
        android:textSize="16sp"
        android:textColor="@color/white"
        tools:text="放大看layout_cons"
        android:layout_marginStart="16dp"
        android:layout_marginEnd="20dp"
        android:singleLine="true"
        android:ellipsize="end"
        />
```
