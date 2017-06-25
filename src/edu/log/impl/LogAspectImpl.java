package edu.log.impl;

import java.sql.Timestamp;
import java.util.Date;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import utils.JsonUtils;
import utils.StringUtils;
import edu.dao.ILogDao;
import edu.log.ILogAspect;
import edu.po.TLog;
import edu.threadlocal.LocalRequestContextHolder;
import edu.vo.UserVO;

public class LogAspectImpl implements ILogAspect {
	
	private Logger logger = Logger.getLogger(LogAspectImpl.class);
	private ILogDao logDao;

	private TLog parseJoinPoint(JoinPoint point) {
		StringBuilder operator = new StringBuilder();
		TLog logEntity = new TLog();
		
		//当前用户信息
		UserVO currentUser = LocalRequestContextHolder.getLocalRequestContext().getCurrentUser();
		if(currentUser != null){
			operator.append("用户：" + currentUser.getUsername() + "，");
			logEntity.setUsername(currentUser.getUsername());
		}
		
		//操作
		operator.append("操作：");
		operator.append(point.getTarget().getClass().getName())
		       .append(".")
			   .append(point.getSignature().getName())
			   .append("方法，");
		operator.append("参数：");
		Object[] args = point.getArgs();
		if (args != null) {
			operator.append("(");
			int i = 1;
			for (Object obj : args) {
				operator.append(obj.getClass()).append(" : ").append(JsonUtils.converToJsonStr(obj));
				if(i == args.length){
					break;
				}
				operator.append(",");
				i++;
			}
			operator.append(")");
		}
		
		logEntity.setOperation(operator.toString());
		logEntity.setCreatedate(new Timestamp(new Date().getTime()));
		
		return logEntity;
	}

	/**
	 * 有参无返回值的方法
	 * 
	 * @param point
	 */
	@Override
	public void logArg(JoinPoint point) {
		TLog logEntity = parseJoinPoint(point);
		save(logEntity);
        logger.info(logEntity.getOperation());
	}

	/**
	 * 有参并有返回值的方法
	 * 
	 * @param point
	 * @param returnObj
	 */
	@Override
	public void logArgAndReturn(JoinPoint point, Object returnObj) {
		TLog logEntity = parseJoinPoint(point);
		StringBuilder opeartor = new StringBuilder();
		opeartor.append(logEntity.getOperation())
		        .append("执行结果是：")
		        .append(returnObj);
		logEntity.setOperation(opeartor.toString());
		save(logEntity);
        logger.info(logEntity.getOperation());
	}


	private boolean save(TLog log) {
		// TODO Auto-generated method stub
		boolean success = true;
		try{
			this.logDao.save(log);
		}catch(Exception e){
			success = false;
			logger.info(StringUtils.getExceptionMessage(e));
		}
		
		return success;
	}

	public ILogDao getLogDao() {
		return logDao;
	}

	public void setLogDao(ILogDao logDao) {
		this.logDao = logDao;
	}
	

}
