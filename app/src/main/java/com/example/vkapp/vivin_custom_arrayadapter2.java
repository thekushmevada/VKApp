package com.example.vkapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

class vivin_custom_arrayadaptor2 extends ArrayAdapter<String> {
    int clickcount=0;
    String[] list;
    Context context;// we create this for giving context for toast

    public vivin_custom_arrayadaptor2(@NonNull Context context, int resource, @NonNull String[] list) {
        super(context, resource, list);
        this.list = list;
        this.context = context;
    }

    // here we have to override two method(getItem,getView)
    @Nullable
    @Override
    public String getItem(int position) {
        return list[position];
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.tab2_layout, parent, false);
        TextView t = convertView.findViewById(R.id.code2);
        t.setText(getItem(position));

        /*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm:ss E");
        LocalDateTime ldt = LocalDateTime.now();
        String sdtf = ldt.format(dtf);
        TextView te = convertView.findViewById(R.id.time);
        te.setText(sdtf);*/

        // on click listener in custom adapter
        ImageView i8 = convertView.findViewById(R.id.imageView8);
        //CardView cv = convertView.findViewById(R.id.cv);
        TextView t11 = convertView.findViewById(R.id.textView11);
        //cv.setVisibility(View.INVISIBLE);
        CardView cv2 = convertView.findViewById(R.id.cardView2);

        View finalConvertView = convertView;
        clickcount=0;
        i8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*CardView.LayoutParams layoutParams = new CardView.LayoutParams(
                        CardView.LayoutParams. MATCH_PARENT ,
                        CardView.LayoutParams. WRAP_CONTENT ) ;
                layoutParams.setMargins( 0 , 0 , 0 ,100 ) ;
                Toast.makeText(context, "heloooooo", Toast.LENGTH_SHORT).show();*/
                /*Button okButton= new Button( this ) ;
                okButton.setText( "some text" ) ;
                ll.addView(okButton , layoutParams) ;*/

                clickcount=clickcount+1;
                if(clickcount%2 == 0)
                {
                    /*Animation animSlideDown = AnimationUtils.loadAnimation(context.getApplicationContext(), R.anim.slide_down);
                    cv.startAnimation(animSlideDown);
                    cv.setVisibility(View.INVISIBLE);*/
                    t11.setText("MORE");
                    ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) cv2.getLayoutParams();
                    params.setMargins(0,0,0,35);
                    cv2.setLayoutParams(params);
                    i8.setImageResource(R.drawable.more);
                }
                else
                {
                    /*Animation animSlideUp = AnimationUtils.loadAnimation(context.getApplicationContext(), R.anim.slide_up);
                    cv.startAnimation(animSlideUp);
                    cv.setVisibility(View.VISIBLE);*/
                    t11.setText("LESS");
                    ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) cv2.getLayoutParams();
                    params.setMargins(0,0,0,1000);
                    cv2.setLayoutParams(params);
                    i8.setImageResource(R.drawable.less);
                }

                /*list[position] = list[position + 1];
                CardView cv2 = finalConvertView.findViewById(R.id.cardView2);
                ViewGroup.LayoutParams p = this.getLayoutParams();*/

            }
        });

        return convertView;
    }
}


