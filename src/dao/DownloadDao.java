package dao;

import dao.IDao.IDownloadDao;
import vo.Download;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class DownloadDao implements IDownloadDao {
    private Connection connection;

    private PreparedStatement preparedStatement;

    public DownloadDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Download getById(Integer id) throws Exception {
        String sql = "SELECT * from t_downloadList where id = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, String.valueOf(id));
        ResultSet resultSet = this.preparedStatement.executeQuery();

        Download download = new Download();
        if(resultSet.next()){
            download.setId(Integer.parseInt(resultSet.getString("id")));
            download.setName(resultSet.getString("name"));
            download.setPath(resultSet.getString("path"));
            download.setDescription(resultSet.getString("description"));
            download.setSize(Float.parseFloat(resultSet.getString("size")));
            download.setStart(Integer.parseInt(resultSet.getString("start")));
            download.setImg(resultSet.getString("img"));

        }
        else{
            download = null;
        }

        return download;
    }

    @Override
    public List<Download> query() throws Exception {
        List<Download> list = new LinkedList<>();
        String sql = "SELECT * from t_downloadList";
        this.preparedStatement = this.connection.prepareStatement(sql);
        ResultSet resultSet = this.preparedStatement.executeQuery();

        while (resultSet.next()){
            Download download = new Download();
            download.setId(Integer.parseInt(resultSet.getString("id")));
            download.setName(resultSet.getString("name"));
            download.setPath(resultSet.getString("path"));
            download.setDescription(resultSet.getString("description"));
            download.setSize(Float.parseFloat(resultSet.getString("size")));
            download.setStart(Integer.parseInt(resultSet.getString("start")));
            download.setImg(resultSet.getString("img"));

            list.add(download);
        }

        return list;
    }

    @Override
    public boolean add(Download download) throws Exception {
        return false;
    }

    @Override
    public boolean update(Download download) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Download download) throws Exception {
        return false;
    }
}
