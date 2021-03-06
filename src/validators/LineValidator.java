package validators;

import elements.Operand;
import exception.StatementException;
import statement.IStatement;

public class LineValidator {
	private IValidator labelValidator, operationValidator, commentValidator;
	private OperandValidator operandValidator;

	public LineValidator() {
		labelValidator = new LabelValidator();
		operationValidator = new OperationValidator();
		operandValidator = new OperandValidator();
		commentValidator = new CommentValidator();
	}

	public boolean validateLine(String[] line, IStatement statement) throws StatementException {
		boolean cond2 = operationValidator.validate(line[1], statement);
		boolean cond1 = labelValidator.validate(line[0], statement);
		boolean cond3 = operandValidator.validate(line[2], statement);
		boolean cond4 = true; // = commentValidator.validate(line[3],
								// statement);
		return cond1 && cond2 && cond3 && cond4;
	}
	 
	public Operand getOperandType(){
		return operandValidator.getOperandType();
	}
}