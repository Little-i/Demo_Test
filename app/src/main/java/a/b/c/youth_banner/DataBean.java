package a.b.c.resolve_address;

import java.util.ArrayList;
import java.util.List;

public class DataBean {
    private Integer imageRes;
    public String imageUrl;
    private String title;
    private int viewType;

    public DataBean(String imageUrl, String title, int viewType) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.viewType = viewType;
    }

    public DataBean(Integer imageRes, String title, int viewType) {
        this.imageRes = imageRes;
        this.title = title;
        this.viewType = viewType;
    }

    public static List<DataBean> getImageData(){
        List<DataBean> dataBeans = new ArrayList<>();
        dataBeans.add(new DataBean("https://i0.hdslb.com/bfs/article/a08d27b5e670c9c2c918edb82a9a7cb22610339b.jpg@942w_566h_progressive.webp",null,1));
        dataBeans.add(new DataBean("https://i0.hdslb.com/bfs/article/0924925b8a956e73b8347d1b3d4c705d765706b0.jpg@942w_666h_progressive.webp",null,1));
        dataBeans.add(new DataBean("https://i0.hdslb.com/bfs/article/97b68f2f0147dfc609f6cd5dae1e701232355ccf.jpg@942w_620h_progressive.webp",null,1));
        return dataBeans;
    }
}
