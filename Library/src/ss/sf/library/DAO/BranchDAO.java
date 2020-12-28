package ss.sf.library.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ss.sf.Domain.Branch;

public class BranchDAO extends BaseDAO<Branch> {
	
	public List<Branch> readBranches() throws SQLException, ClassNotFoundException {
		return read("select * from tbl_library_branch", null);
	}
	public void deleteBranch(int branchId) throws ClassNotFoundException {
		save("DELETE from tbl_library_branch where branchId = ?", new Object[] {branchId});
	}
	public void updateBranch(Branch branch) throws SQLException, ClassNotFoundException {
		save("update tbl_library_branch set branchName=?,branchAddress=? where branchId = ?",
				new Object[] { branch.getBranchName(), branch.getBranchAddress(), branch.getBranchId() });
		
	}
	public void addBranch(Branch branch) throws ClassNotFoundException {
		save("INSERT into tbl_library_branch values(?,?,?)", new Object[] {branch.getBranchId(),branch.getBranchName(),branch.getBranchAddress()});
	}
	@Override
	List<Branch> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Branch> branches = new ArrayList<>();
		while (rs.next()) {
			Branch branch = new Branch();
			branch.setBranchId(rs.getInt("branchId"));
			branch.setBranchName(rs.getString("branchName"));
			branch.setBranchAddress(rs.getString("branchAddress"));
			branches.add(branch);
		}
		return branches;
	}

}
