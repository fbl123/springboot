//package 设计模式.单例模式;
//
//import com.github.pagehelper.PageHelper;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class CallForm {
//
//
//    private String callNumber;//通话人号码
//    private Long date; //通话时间  时间戳
//    private Integer duration;  //通话时长 秒
//    private String status;  //类型  1 打出 out  2 接听 in 3 未接
//    private String callName; //通话人备注
//


//    /**
//     * 保存用户通话记录
//     * @param
//     * @return
//     */
////    @PostMapping("/saveCallLog")
//    public CommonRestResult saveCallLog(@RequestBody List<CallForm> list) {
//        return RestBusinessTemplate.transaction(() -> {
//            //判断用户是否已登录
//            String userId = SecurityUtils.getCurrentUserId();
//            if (StringUtils.isBlank(userId)) {
//                // 这个接口不要抛出异常
//                logger.warn("保存用户短信 失败 用户未登录");
//                return false;
//            }
//
//            return  true;
//        });
//    }
//
//
//
//    /**
//     * 展示用户姓名或手机号
//     * @return
//     */
//    public CommonRestResult getUserName(){
//        return RestBusinessTemplate.transaction(() -> {
//            SecurityUser user = SecurityUtils.getCurrentUser();
////            if(user==null){
////                //没有登录
////                return null;
////            }
////            Map<String,String> map=new HashMap<>();
////            map.put("name",user.getUsername());
////            map.put("mobile",user.getMobile());
////            return map;
//            return user;
//        });
//    }
//
//
//
//    /**
//     * 获取用户设备详情
//     *
//     * @param orderNo
//     * @return
//     */
//    public CommonRestResult getEquipmentInfo(@RequestParam(value = "orderNo") String orderNo) {
//        return RestBusinessTemplate.execute(() -> {
//
//            Map<String, String> map = null;
//            LoanOrderDO loanOrderDO = loanOrderJpaDAO.findByOrderNo(orderNo);
//            List<UserOnlineLogDO> list = userOnlineLogJpaDAO.findByUserIdOrderByIdDesc(loanOrderDO.getUserId());
//            if (null != list && list.size() > 0) {
//                //获取最后登录的信息
//                UserOnlineLogDO userOnlineLogDO = list.get(0);
//                map = new HashMap<>();
//                map.put("phone_brands", userOnlineLogDO.getPhoneBrands()); //手机品牌
//                map.put("phoneType", userOnlineLogDO.getPhoneType()); //手机型号
//                map.put("platform", userOnlineLogDO.getPlatform());  //平台类型
//                map.put("DeviceId", userOnlineLogDO.getDeviceId()); //设备号
//                map.put("ip", userOnlineLogDO.getIp()); //ip
//
//            }
//            return map;
//        });
//    }
//
//    /**
//     * 获取通话记录
//     *
//     * @param pageIndex
//     * @param pageSize
//     * @param orderNo
//     * @return
//     */
//    public CommonRestResult getCllLog(@RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
//                                      @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
//                                      @RequestParam(value = "orderNo") String orderNo) {
//        return RestBusinessTemplate.execute(() -> {
//            //获取用户ID
//            Long userId=getUserId(orderNo);
//
//            PageHelper.startPage(pageIndex, pageSize);
//            List list = null;
//            return PageUtil.toPage(list);
//        });
//
//    }
//
//    private Long getUserId(String orderNo){
//        return loanOrderJpaDAO.findByOrderNo(orderNo).getUserId();
//    }
//    /**
//     * 用户紧急联系人
//     *
//     * @param pageIndex
//     * @param pageSize
//     * @param orderNo
//     * @return
//     */
//    public CommonRestResult emergencyContact(@RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
//                                             @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
//                                             @RequestParam(value = "orderNo") String orderNo) {
//        return RestBusinessTemplate.execute(() -> {
//            //获取用户ID
////            loanOrderJpaDAO.findByOrderNo(orderNo).getUserId();
//            getUserId(orderNo);
//            //获取用户填写的紧急联系人的电话
//
//            return null;
//        });
//
//    }
//}
