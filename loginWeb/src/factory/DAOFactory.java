package factory;


import dao.IDownloadDao;
import dao.IUserDao;
import dao.impl.IDownloadDaoImpl;
import dao.impl.IUserDaoImpl;

import java.sql.Connection;

public class DAOFactory {
    public static IUserDao getUserDAOInstance(Connection con) {

        return new IUserDaoImpl(con);
    }
    public static IDownloadDao getDownloadDAOInstance(Connection con){
        return new IDownloadDaoImpl(con);
    }
}
