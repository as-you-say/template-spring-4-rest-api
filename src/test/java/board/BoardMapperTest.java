package board;

import org.example.template.api.account.mapper.AccountMapper;
import org.example.template.api.board.mapper.BoardMapper;
import org.example.template.api.role.mapper.RoleMapper;
import org.example.template.model.Account;
import org.example.template.model.Board;
import org.example.template.model.Role;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
        "classpath:config/mybatis-config.xml",
        "file:src/main/webapp/WEB-INF/spring/database-context.xml",
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardMapperTest {

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    BoardMapper boardMapper;

    @Test
    public void TEST_1_selectBoardList() throws Exception{
        // 데이터
        Account account = new Account();
        account.setUsername("board@gmail.com");
        account.setPassword("board");
        accountMapper.insertAccount(account);
        Board board = new Board();
        board.setTitle("Title");
        board.setContent("Content");
        board.setAccount_id(account.getId());
        boardMapper.insertBoard(board);

        // 작업
        Board param = new Board();
        param.setLimit(10);
        param.setOffset(0);
        List<Board> boards = boardMapper.selectBoardList(param);

        // 결과
        Assert.assertNotNull(boards);
        Assert.assertTrue(boards.size() > 0);

        // 초기화
        boardMapper.deleteBoard(board);
        accountMapper.deleteAccount(account);
    }

    @Test
    public void TEST_2_selectBoardById() throws Exception{
        // 데이터
        Account account = new Account();
        account.setUsername("board@gmail.com");
        account.setPassword("board");
        accountMapper.insertAccount(account);
        Board board = new Board();
        board.setTitle("Title");
        board.setContent("Content");
        board.setAccount_id(account.getId());
        boardMapper.insertBoard(board);

        // 작업
        Board result = boardMapper.selectBoardById(board);

        // 결과
        Assert.assertNotNull(result);
        Assert.assertEquals("Title", result.getTitle());

        // 초기화
        boardMapper.deleteBoard(board);
        accountMapper.deleteAccount(account);
    }

    @Test
    public void TEST_3_insertBoard() throws Exception{
        // 데이터
        Account account = new Account();
        account.setUsername("board@gmail.com");
        account.setPassword("board");
        accountMapper.insertAccount(account);

        // 작업
        Board board = new Board();
        board.setTitle("Title");
        board.setContent("Content");
        board.setAccount_id(account.getId());
        boardMapper.insertBoard(board);
        Board result = boardMapper.selectBoardById(board);

        // 결과
        Assert.assertNotNull(result);
        Assert.assertEquals("Title", result.getTitle());

        // 초기화
        boardMapper.deleteBoard(board);
        accountMapper.deleteAccount(account);
    }

    @Test
    public void TEST_4_updateBoard() throws Exception{
        // 데이터
        Account account = new Account();
        account.setUsername("board@gmail.com");
        account.setPassword("board");
        accountMapper.insertAccount(account);
        Board board = new Board();
        board.setTitle("Title");
        board.setContent("Content");
        board.setAccount_id(account.getId());
        boardMapper.insertBoard(board);

        // 작업
        board.setTitle("Title_Update");
        board.setContent("Content_Update");
        boardMapper.updateBoard(board);
        Board result = boardMapper.selectBoardById(board);

        // 결과
        Assert.assertNotNull(result);
        Assert.assertEquals("Title_Update", result.getTitle());
        Assert.assertEquals("Content_Update", result.getContent());

        // 초기화
        boardMapper.deleteBoard(board);
        accountMapper.deleteAccount(account);
    }

    @Test
    public void TEST_5_deleteBoard() throws Exception{
        // 데이터
        Account account = new Account();
        account.setUsername("board@gmail.com");
        account.setPassword("board");
        accountMapper.insertAccount(account);
        Board board = new Board();
        board.setTitle("Title");
        board.setContent("Content");
        board.setAccount_id(account.getId());
        boardMapper.insertBoard(board);

        // 작업
        boardMapper.deleteBoard(board);
        Board result = boardMapper.selectBoardById(board);

        // 결과
        Assert.assertNull(result);

        // 초기화
        boardMapper.deleteBoard(board);
        accountMapper.deleteAccount(account);
    }

}
