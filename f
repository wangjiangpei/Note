//    private void createNotification() {
//        RemoteViews views = new RemoteViews(getPackageName(), R.layout.layout_nitification);//自定义的布局视图
//按钮点击事件：
//
//        PendingIntent homeIntent = PendingIntent.getBroadcast(this, 1, new Intent("action"), PendingIntent.FLAG_UPDATE_CURRENT);
//
//        views.setOnClickPendingIntent(R.id.btn, homeIntent);
//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext());
//
//        mBuilder.setContent(views)//设置布局
//
//                .setOngoing(true)//设置是否常驻,true为常驻
//
//                .setSmallIcon(R.mipmap.ic_launcher)//设置小图标
//                .setTicker("通知来了")//设置提示
//
//                .setPriority(Notification.PRIORITY_MAX)//设置优先级
//
//                .setWhen(System.currentTimeMillis())//设置展示时间
//
//                .setContentIntent(PendingIntent.getBroadcast(this, 2, new Intent("action.view"), PendingIntent.FLAG_UPDATE_CURRENT));//设置视图点击事件
//
//        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//
//        mNotificationManager.notify(100, mBuilder.build());
//    }