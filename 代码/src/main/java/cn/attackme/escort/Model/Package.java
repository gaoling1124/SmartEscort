package cn.attackme.escort.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 包裹
 * Created by hujian on 2017/3/24.
 */
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Package implements Serializable {

    private static final long serialVersionUID = -4591451869882553177L;

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator",strategy = "increment")
    private Integer id;

    //代理人
    @OneToOne
    @JoinColumn(name = "agency")
    private User agency;

    //委托人
    @OneToOne
    @JoinColumn(name = "delegation")
    private User delegation;

    //代理费
    @OneToOne
    @JoinColumn(name = "standard")
    private Standard standard;

    //取件凭证
    @OneToOne
    @JoinColumn(name = "certificate")
    private Certificate certificate;

    //快递公司
    @OneToOne
    @JoinColumn(name = "courierCompany")
    private CourierCompany courierCompany;

    //留言
    private String note;

    //满意程度
    private Integer score;

    //任务发布时间
    private Date publishTime;

    //任务领悟时间
    private Date receiveTime;

    //代理人对委托人的评价
    @OneToOne
    @JoinColumn(name = "agencyEvaluation")
    private Evaluation agencyEvaluation;

    //委托人对代理人的评价
    @OneToOne
    @JoinColumn(name = "delegationEvaluation")
    private Evaluation delegationEvaluation;

    //包裹开始派送时间
    private Date beginTime;

    //委托人签收时间
    private Date endTime;

    //包裹状态
    @Enumerated(EnumType.STRING)
    private PackageStatus packageStatus;
}
