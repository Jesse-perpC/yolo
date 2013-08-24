package com.ustream.loggy.module.processor;

import com.ustream.loggy.config.ConfigException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author bandesz <bandesz@ustream.tv>
 */
public class CompositeProcessor implements IProcessor, ICompositeProcessor
{

    private final List<IProcessor> processors = new ArrayList<IProcessor>();

    @Override
    public void validateProcessorParams(List<String> parserParams, Map<String, Object> params) throws ConfigException
    {
    }

    @Override
    public void process(Map<String, String> parserParams, Map<String, Object> processorParams)
    {
        for (IProcessor processor : processors)
        {
            processor.process(parserParams, processorParams);
        }
    }

    @Override
    public void setUp(Map<String, Object> parameters, boolean debug)
    {
    }

    @Override
    public void addProcessor(IProcessor processor)
    {
        processors.add(processor);
    }
}
