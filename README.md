# ArcLayout


![image](https://github.com/maiduoduo/IArcLayout/blob/master/screenshot/ico_logo.png)

<br/><br/>

[![screen](https://github.com/maiduoduo/IArcLayout/blob/master/screenshot/arclayout-optimize.gif)](https://github.com/maiduoduo/IArcLayout/blob/master/screenshot/arclayout-optimize.gif)

<br/>

**基于material design用弧形布局探索View设计的新风格和方法**

> 支持对View进行弧度处理，支持嵌入、单View
>
> 支持设置弧度值，值越大弧度越大
>
> 支持设置弧度的方向，内凹，外凸
>
> 支持广告banner的弧度设置，自定义指示器的样式。
>
> 其他等请查看演示Demo
>



<br/><br/>
<br/><br/>





<br/><br/>

#### 使用

---

> 想要改变弧度的方向，内凹还是外凸，还是正常矩形都依赖app:arc_cropDirection参数
>
> * 内凹：app:arc_cropDirection="cropInside"
>
> * 外凸：app:arc_cropDirection="cropOutside"
>
> * 正常：只需app:arc_height参数值设为0dp,即：**app:arc_height="0dp"**,和app:arc_cropDirection参数无关
>


<br/><br/>

##### ==1.内凹类型==

> 在ArcLayout内可以包含其他View，不止Banner
> * 内凹：app:arc_cropDirection="cropInside"


```xml
 <com.imaiduoduo.arclayout.lib.ArcLayout
                    android:id="@+id/ArcLayoutInside"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_alignParentStart="true"
                    android:layout_alignParentLeft="true"
                    android:layout_alignParentTop="true"
                    android:elevation="1dip"
                    app:arc_cropDirection="cropInside"
                    app:arc_height="20dp"
                    app:arc_position="bottom">

                    <com.youth.banner.Banner
                        android:id="@+id/mBannerInside"
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        app:banner_default_image="@drawable/default_img_guji"
                        app:image_scale_type="fit_xy"
                        app:indicator_height="5dp"
                        app:indicator_margin="5dp"
                        app:indicator_width="5dp" />

                </com.imaiduoduo.arclayout.lib.ArcLayout>
```

<br/>

![image](https://github.com/maiduoduo/IArcLayout/blob/master/screenshot/ARC_A.jpg)

<br/><br/>

##### ==外凸类型==

> 在ArcLayout内可以包含其他View，不止Banner
> * 外凸：app:arc_cropDirection="cropOutside"

```xml

 <com.imaiduoduo.arclayout.lib.ArcLayout
                    android:id="@+id/ArcLayoutOutside"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_alignParentStart="true"
                    android:layout_alignParentLeft="true"
                    android:layout_alignParentTop="true"
                    android:elevation="1dip"
                    app:arc_cropDirection="cropOutside"
                    app:arc_height="15dp"
                    app:arc_position="bottom">

                    <com.youth.banner.Banner
                        android:id="@+id/mBannerOutside"
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        app:banner_default_image="@drawable/default_img_guji"
                        app:image_scale_type="fit_xy"
                        app:indicator_height="5dp"
                        app:indicator_margin="5dp"
                        app:indicator_width="5dp" />
                </com.imaiduoduo.arclayout.lib.ArcLayout>

```

<br/>

![image](https://github.com/maiduoduo/IArcLayout/blob/master/screenshot/arc_d_outer_clip.jpg)

<br/><br/>

##### ==矩形（正常）类型==

> 在ArcLayout内可以包含其他View，不止Banner
> * 矩形：**app:arc_height="0dp"**

```xml

 <com.imaiduoduo.arclayout.lib.ArcLayout
                    android:id="@+id/ArcLayoutNormal"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_alignParentStart="true"
                    android:layout_alignParentLeft="true"
                    android:layout_alignParentTop="true"
                    android:elevation="1dip"
                    app:arc_cropDirection="cropInside"
                    app:arc_height="0dp"
                    app:arc_position="bottom">

                    <com.youth.banner.Banner
                        android:id="@+id/mBannerNormal"
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        app:banner_default_image="@drawable/default_img_guji"
                        app:image_scale_type="fit_xy"
                        app:indicator_drawable_selected="@drawable/news_banner_heart_red_enabled"
                        app:indicator_drawable_unselected="@drawable/news_banner_heart_white_enabled"
                        app:indicator_height="5dp"
                        app:indicator_margin="5dp"
                        app:indicator_width="5dp" />
</com.imaiduoduo.arclayout.lib.ArcLayout>

```

<br/>

![image](https://github.com/maiduoduo/IArcLayout/blob/master/screenshot/ARC_C.jpg)


<br/><br/>

#### 例子

---

##### 外切弧

```xml
<com.imaiduoduo.arclayout.lib.ArcLayout
          android:layout_width="match_parent"
          android:layout_height="200dp"
          app:arc_cropDirection="cropOutside"
          app:arc_height="90dp"
          app:arc_padding="30dp"
          android:elevation="5dp">
          <ImageView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:scaleType="centerCrop"
                android:src="@drawable/road" />

 </com.imaiduoduo.arclayout.lib.ArcLayout>
```



<br/><br/>

##### 内切弧

```xml
<com.imaiduoduo.arclayout.lib.ArcLayout
          android:layout_width="match_parent"
          android:layout_height="200dp"
          app:arc_cropDirection="cropInside"
          app:arc_height="90dp"
          app:arc_padding="30dp"
          android:elevation="5dp">

          <ImageView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:scaleType="centerCrop"
                android:src="@drawable/road" />

 </com.imaiduoduo.arclayout.lib.ArcLayout>
```

<br/><br/>


<br/><br/>

### Download

---

try this demo apk [![Download](https://github.com/maiduoduo/IArcLayout/blob/master/screenshot/svg/download.svg)](https://www.lanzous.com/i7sfqgh)

<br/><br/>

### Inspirations

---


The new Star Wars movie is coming soon, so I decided to design this cinema app screen with one of the Rogue One posters.
Also, I tried something new: notice, that the white rectangle on the bottom is bended, which makes the design a bit more lively. The app bar has a reduced opacity and the image behind it is blurred to get a unique look.
I'd appreciate any feedback.



新的超体2即将上映，所以我决定设计这个电影应用程序屏幕与超体一海报。
另外，我尝试了一些新的东西：注意，底部的白色矩形是弯曲的，这使得设计更加生动。应用程序条的不透明度降低，其后面的图像模糊，以获得独特的外观。
如有任何反馈，我将不胜感激。


[![screen](https://github.com/maiduoduo/IArcLayout/blob/master/screenshot/preview.png)](https://github.com/maiduoduo/IArcLayout/blob/master/screenshot/preview.png)


<br/><br/>

### ABOUT ME

---

**`maiduoduo`**

邮箱：	[maiduoduo0@163.com](maiduoduo0@163.com)

博客主页：	[https://blog.csdn.net/Maiduoudo](https://blog.csdn.net/Maiduoudo)

Github主页：	[https://github.com/maiduoduo/](https://github.com/maiduoduo/)


<br/><br/>

### THANKS

[florent37](https://github.com/florent37)

若侵联删：	[maiduoduo0@163.com](maiduoduo0@163.com)

<br/>

License

--------



    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
