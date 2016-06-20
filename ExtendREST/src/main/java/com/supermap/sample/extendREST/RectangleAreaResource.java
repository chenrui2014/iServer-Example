package com.supermap.sample.extendREST;
import java.util.HashMap;
import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import com.supermap.services.components.Map;
import com.supermap.services.components.MapException;
import com.supermap.services.components.commontypes.MeasureParameter;
import com.supermap.services.components.commontypes.MeasureResult;
import com.supermap.services.components.commontypes.Point2D;
import com.supermap.services.components.commontypes.Rectangle2D;
import com.supermap.services.components.commontypes.Unit;
import com.supermap.services.rest.resources.SimpleAlgorithmResultResourceBase;
import com.supermap.services.rest.util.MappingUtil;
public class RectangleAreaResource extends SimpleAlgorithmResultResourceBase{
    private String mapName;
    private MappingUtil mappingUtil;
    
    public RectangleAreaResource(Context context, Request request, Response response) {
        super(context, request, response);
        mappingUtil = new MappingUtil(this);
        this.mapName = this.mappingUtil.getMapName(this.getRequest());
        this.mapName = this.mapName.trim();
    }
    //判断资源是否存在
    public boolean isResourceExist(){
//      Logger.info("rectangle area resource exist");
        boolean flag = false;
        flag = this.mappingUtil.isMapExist(this.mapName);
        return flag;
    }
  //运行算法得到结果
    protected Object runArithMetic(java.util.Map params){
        Object arithResult=null;
        //如果参数为空，返回 area 字段为 -1
        if(params==null||0==params.size()){
            MeasureResult  result =   new MeasureResult();
            result.area = -1;
            arithResult = result ;
        }else{
                Rectangle2D rect = (Rectangle2D)params.get("rect2D");
            Unit  unit = (Unit)params.get("unit");
            //单位参数可以不传，默认为米。
            if(unit == null){
                unit = Unit.METER;
            }
            //量算参数类，其中存储了单位信息。
            MeasureParameter measureParam = new MeasureParameter();
            measureParam.unit = unit;
            //将 Rectangle2D 转化为 Point2Ds
            Point2D leftBottom=rect.leftBottom;
            Point2D rightTop=rect.rightTop;
            Point2D leftTop=new Point2D(leftBottom.x,rightTop.y);
            Point2D rightBottom=new Point2D(rightTop.x,leftBottom.y);
            Point2D[] point2Ds={leftBottom,leftTop,rightTop,rightBottom};
            
            //量算结果
            try {
                Map mapComponent = this.mappingUtil.getMapComponent(mapName);
                                arithResult = mapComponent.measureArea(mapName, point2Ds, measureParam);
                        } catch (MapException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
        }
        
        return arithResult;
    }
    //给出算法参数的类型，即请求参数的结构。
    protected java.util.Map<String, Class> createArithParamClassMappings(){
        java.util.Map<String, Class> paramClassMapping = new HashMap<String, Class>();
        paramClassMapping.put("rect2D", Rectangle2D.class);
        paramClassMapping.put("unit", Unit.class);
        return paramClassMapping;
    }
    
    //判断 URI 中的参数是否合法，不合法则抛出异常。为了示例的清晰，这里没有判断。
        protected void checkUrlParamValid(java.util.Map arg0) {
                // TODO Auto-generated method stub
                
        }
}