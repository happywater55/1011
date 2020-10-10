package dao.IDao;

import vo.Download;
import vo.User;

import java.util.List;

public interface IDownloadDao {
    public Download getById(Integer id) throws Exception;

    public List<Download> query() throws Exception;

    public boolean add(Download download) throws  Exception;

    public boolean update(Download download) throws Exception;

    public boolean delete(Download download) throws Exception;
}
