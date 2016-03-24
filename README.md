# BottomBarNavigation
Android design pattern based BottomBarNavigation 

Android specific bottom bar navigation should be based on some specification, which is described in Google's site (mentioned below)
<br/>
https://www.google.com/design/spec/components/bottom-navigation.html

<h2>Objective</h2>
<p>To create a library for android projects, to easily implement the bottom bar navigation</p>

<h4>Current Version:</h4>
<ul>
  <li>Can add upto 3 buttons in the bottom bar</li>
  <li>Can change colors of the bottom bar and bottom bar button texts</li>
</ul>
<h4>Future versions:</h4>
<ul>
  <li>Add a class to create a button drawable, requires only a drawable_icon and color of the normal and pressed state</li>
  <li>Configure to add more than 3 buttons in the bottom bar</li>
  <li>Make the integration of the library much simpler and generic</li>
</ul>

<h2>Integration:</h2>
Import as a module into your android project.
<p>Add dependency in your gradle</p>
<h5>build.gradle :</h5>
<pre>
  <code>
  compile project(':bottomBarNavigation')
  </code>
</pre>
<h5>check in settings.gradle :</h5>
<pre>
  <code>
  include ':yourprojectname', ':bottomBarNavigation'
  </code>
</pre>
<h5>Add BottomBar in your preferred layout : </h5>
```xml
<com.karthyks.bottombarview.views.BottomBarView
          android:id="@+id/bottom_bar"
          android:layout_width="match_parent"
          android:layout_height="match_parent">
</com.karthyks.bottombarview.views.BottomBarView>
```
<h5>In your activity class : </h5>
<pre>
  <code>
    bottomBarView = (BottomBarView) view.findViewById(R.id.bottom_bar);
    bottomBarView.setBgColor(Color.GRAY);
  </code>
</pre>

<h5>create a layout xml and add buttons in it</h5>
<p>include_bottom_bar_buttons.xml</p>
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              android:gravity="center"
              android:orientation="horizontal">
    <com.karthyks.bottombarview.views.BottomBarButton
        android:id="@+id/btn_1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

    <com.karthyks.bottombarview.views.BottomBarButton
        android:id="@+id/btn_2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

    <com.karthyks.bottombarview.views.BottomBarButton
        android:id="@+id/btn_3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
</LinearLayout>
```

<h5>Then add the buttons to your bottomBarView in your activity : </h5>
<pre>
  <code>
    bottomBarView.addAsChild(R.layout.include_bottom_bar_buttons);
  </code>
</pre>

<h5>Finally build your custom buttons</h5>
<pre>
  <code>
  private void buildBottomBarButtons() {
    btn1.setButtonDrawables(int DrawableNormal, int DrawablePressed)
        .setButtonText("BUTTON_TEXT")
        .setTextColors(int colorNormal, int colorPressed)
        .setBgColor(Color.GRAY)
        .build();
    btn2.setButtonDrawables(int DrawableNormal, int DrawablePressed)
        .setButtonText("BUTTON_TEXT")
        .setTextColors(int colorNormal, int colorPressed)
        .setBgColor(Color.GRAY)
        .build();
    btn3.setButtonDrawables(int DrawableNormal, int DrawablePressed)
        .setButtonText("BUTTON_TEXT")
        .setTextColors(int colorNormal, int colorPressed)
        .setBgColor(Color.GRAY)
        .build();
    btn1.setOnClickListener(this);
    btn2.setOnClickListener(this);
    btn3.setOnClickListener(this);
  }
  </code>
</pre>

<br/>
<br/>
<br/>

<h4>*** Note *** </h4>
<h6>Changes are appreciated</h6>
<p>Feel free to fork your changes in the library.Since this is my first library project, I am sure there will be a lot of suggestions from Geekies.</p>
