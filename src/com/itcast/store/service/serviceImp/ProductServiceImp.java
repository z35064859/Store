package com.itcast.store.service.serviceImp;

import java.sql.SQLException;
import java.util.List;

import com.itcast.store.dao.ProductDao;
import com.itcast.store.dao.daoImp.ProductDaoImp;
import com.itcast.store.domain.Product;
import com.itcast.store.service.ProductService;
import com.itcast.store.utils.PageModel;
import com.sun.corba.se.impl.logging.OMGSystemException;

public class ProductServiceImp implements ProductService {

    @Override
    public List<Product> findHots() throws SQLException{
        ProductDao productDao=new ProductDaoImp();
        List<Product> listHots=productDao.findHots();
        return listHots;
    }

    @Override
    public List<Product> findNews() throws SQLException {
        ProductDao productDao=new ProductDaoImp();
        List<Product> listNews=productDao.findNews();
        return listNews;
    }

    @Override
    public Product findProductById(String str) throws SQLException {
        ProductDao productDao=new ProductDaoImp();
        Product product=productDao.fingProductById(str);
        return product;
    }

    @Override
    public PageModel findProductsByCidWithPage(String cid, String num) throws SQLException {
        // TODO Auto-generated method stub
        //统计总数量
        int totalRecords=ProductDao.findTotalRecords(cid);
        System.out.println("共"+totalRecords+"条");
        PageModel pModel=new PageModel(Integer.parseInt(num), 12, totalRecords);
        List list=ProductDao.findProductsByCidWithPage(cid,pModel.getStartIndex(),pModel.getPageSize());
        pModel.setList(list);
        pModel.setUrl("ProductServlet?method=findProductsByCidWithPage&cid="+cid);
        return pModel;
    }

}
