***  
# 作品 ：仿写部分功能的安卓壁纸； 
# 作者：高锋
## 一
#### 作品描述 ：
* 我用安卓壁纸的Api仿写了安卓壁纸的一部分功能，可以加载他的推荐图片，手机壁纸分类，电脑壁纸分类，电脑专辑，并显示各类别下的图片，点击图片还可以进入另一个活动单独查看这个图片的原图，再点击下面的评论可以看到网友对该图片的相关的评论。
***
#### 感受 ：
* 一开始十分迷茫，对于写app不知所措，并且之前也欠了许多债，在放假之后也是看了许多视频然后慢慢补起来，我本身对好看的图片很喜欢，在学长学姐提供的api中也是找到了安卓壁纸这个软件得Api，并了解了一下这个软件得布局，感觉就是ViewPager里面嵌套了RecyclerView来实现，对自己来说还是很有难度。
***
#### 体会 ：
* 面对一个挑战不应轻易放弃，虽然我在上学期放假前欠了许多账，但我仍然再坚持努力的走下去，在红岩的这段日子也磨练了我，让我变得更加成熟，在这次寒假作业中我也学到了许多知识，对于Android也不会像以前一样不知所措。
## 二
#### 功能及操作方式
###### 1 
* 开始安装此软件时需注册账号密码并记录在手机中，如果点记住密码以后则会自动登陆进入主界面。
###### 2
* 下方有两个图标，一个是手机，一个是电脑，手机代表手机壁纸，电脑代表电脑壁纸，点击下方的图标可以进入相应的活动看到相应的壁纸。
###### 3
* 点击手机壁纸的推荐图片可以查看原图，点击评论可以查看网友对此图片的评论，如果没有评论则会弹窗告诉用户没有评论，点击分类的图片或者专辑则会查看该类或者专辑下的图片，在专辑的上面有推荐专辑的轮播条（抄的......还是太low了）。
## 三
#### 实现功能使用到的技术与知识点
###### 1
* 账户密码功能：使用SharedPreferences储存最开始注册的账号，并储存是否登陆过，登陆过则显示登陆而不是注册，设置记住密码（多选框），如果记住密码则自动登陆进入主界面。

![](https://github.com/KoArthur/AndroidBackground/blob/master/Gif/1551108575762.gif)
###### 2
* 加载布局时使用Hander处理子线程与主线程，让布局加载更加流畅以及完整

![](https://github.com/KoArthur/AndroidBackground/blob/master/Gif/1551109756092.gif)
###### 3
* 实现左右滑动与上下滑动便于查看图片：使用TabLayout与ViewPager，并在ViewPager里面嵌套RecyclerView，在TB与VP的的碎片中加载RV，并在RV的适配器中设置每个图片的点击事件并通过Intend（在被启动的布局写入actionStart方法启动活动）传入数据给相应跳转的活动，以加载数据。
###### 4
* 图片加载：使用Picasso加载图片显示RV中，设置加载中图片与失败图片。

![](https://github.com/KoArthur/AndroidBackground/blob/master/Gif/1551108398051.gif)

![](https://github.com/KoArthur/AndroidBackground/blob/master/Gif/1551108314337.gif)

![](https://github.com/KoArthur/AndroidBackground/blob/master/Gif/1551108206474.gif)
###### 5
* 广告轮播条：抄的没什么好说的。
