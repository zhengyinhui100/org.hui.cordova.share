
package org.hui.cordova.share;

import android.content.Context;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.onekeyshare.OnekeyShareTheme;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class Share extends CordovaPlugin {
	private Context context;

    /**
     * Constructor.
     */
    public Share() {
    }
    
    private void showShare(String title, String content, String url,
    		String imgUrl, String comment, String site) {
    	context=this.cordova.getActivity(); 
    	ShareSDK.initSDK(context);
    	OnekeyShare oks = new OnekeyShare();
    	// 关闭sso授权
    	oks.disableSSOWhenAuthorize();
    	// 分享时Notification的图标和文字
    	// oks.setNotification(R.drawable.ic_launcher,context.getString(R.string.app_name));
    	// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
    	oks.setTitle(title);
    	// titleUrl是标题的网络链接，仅在人人网和QQ空间使用
    	oks.setTitleUrl(url);
    	// text是分享文本，所有平台都需要这个字段
    	oks.setText(content);
    	// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//    	oks.setImagePath(imgUrl);// 确保SDcard下面存在此张图片
    	//网络图片url
    	oks.setImageUrl(imgUrl);
    	// url仅在微信（包括好友和朋友圈）中使用
    	oks.setUrl(url);
    	// comment是我对这条分享的评论，仅在人人网和QQ空间使用
    	oks.setComment(comment);
    	// site是分享此内容的网站名称，仅在QQ空间使用
    	oks.setSite(site);
    	// siteUrl是分享此内容的网站地址，仅在QQ空间使用
    	oks.setSiteUrl(url);
    	oks.setDialogMode();
    	oks.setTheme(OnekeyShareTheme.CLASSIC);
    	// 启动分享GUI
    	oks.show(context);
    }
    

    /**
     * Executes the request and returns PluginResult.
     *
     * @param action            The action to execute.
     * @param args              JSONArray of arguments for the plugin.
     * @param callbackContext   The callback context used when calling back into JavaScript.
     * @return                  True when the action was valid, false otherwise.
     */
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
//    	showShare(title,content,url, imgUrl,  comment,  site);
    	showShare(args.getString(0),args.getString(1),args.getString(2),args.getString(3),args.getString(4),args.getString(5));
        // Only alert and confirm are async.
        callbackContext.success(args.getString(1));
        return true;
    }
    	

    
}
